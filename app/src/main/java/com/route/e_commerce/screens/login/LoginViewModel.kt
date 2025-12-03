package com.route.e_commerce.screens.login

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.route.domin.base.Resource
import com.route.domin.entities.auth.request.LoginRequestEntity
import com.route.domin.useCase.auth.LoginUseCase
import com.route.domin.useCase.localStorage.SetTokenUseCase
import com.route.e_commerce.utils.ValidationUtils
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase,
    private val setTokenUseCase: SetTokenUseCase
) : ViewModel(), LoginContract.ViewModel {
    val emailState = mutableStateOf<String>("")
    val emailErrorState = mutableStateOf<String?>(null)
    val passwordState = mutableStateOf<String>("")
    val passwordErrorState = mutableStateOf<String?>(null)
    private val _state: MutableState<LoginContract.States> =
        mutableStateOf(LoginContract.States.Initial)
    private val _events: MutableState<LoginContract.Events> =
        mutableStateOf(LoginContract.Events.Initial)


    // Track if validation has been triggered for each field
    private val emailValidationTriggered = mutableStateOf(false)
    private val passwordValidationTriggered = mutableStateOf(false)

    override val states: State<LoginContract.States>
        get() = _state
    override val events: State<LoginContract.Events>
        get() = _events

    override fun handleIntent(intent: LoginContract.Intent) {
        when (intent) {
            LoginContract.Intent.Initial -> {

            }

            LoginContract.Intent.LoginClicked -> {
                login()

            }

            LoginContract.Intent.RegisterClicked -> {
                _events.value = LoginContract.Events.NavigateToRegister
//                viewModelScope.launch {
//                    delay(1_000)
//                    resetState()
//                }

            }
        }
    }

    fun login() {
        if (validateFields()) {
            viewModelScope.launch {
                _state.value = LoginContract.States.Loading
                _events.value = LoginContract.Events.ShowLoading

                val response = loginUseCase.invoke(
                    LoginRequestEntity(
                        email = emailState.value,
                        password = passwordState.value
                    )
                )

                when (response) {
                    is Resource.Success -> {
                        _events.value = LoginContract.Events.Initial
                        if (response.data != null) {
                            _state.value = LoginContract.States.Success(response.data!!)
                            //save token in Data Store
                            setTokenUseCase.invoke(response.data?.token?:"")
                            // Delay navigation to show toast
                            _events.value = LoginContract.Events.NavigateToHome
                        }
                    }

                    is Resource.Failure -> {
                        _events.value = LoginContract.Events.Initial
                        _state.value = LoginContract.States.Error(response.message)
                        _events.value = LoginContract.Events.ShowError(response.message)
                    }
                }
            }
        }
    }

    /**
     * Validates email field
     * @return true if valid, false otherwise
     */
    fun validateEmail(): Boolean {
        emailValidationTriggered.value = true
        val error = ValidationUtils.validateEmail(emailState.value.trim())
        emailErrorState.value = error
        return error == null
    }

    /**
     * Validates password field
     * @return true if valid, false otherwise
     */
    fun validatePassword(): Boolean {
        passwordValidationTriggered.value = true
        val error = ValidationUtils.validateLoginPassword(passwordState.value)
        passwordErrorState.value = error
        return error == null
    }

    /**
     * Validates all fields
     * @return true if all fields are valid, false otherwise
     */
    fun validateFields(): Boolean {
        val isEmailValid = validateEmail()
        val isPasswordValid = validatePassword()
        return isEmailValid && isPasswordValid
    }

    /**
     * Clears error states and validation triggers
     */
    fun clearErrors() {
        emailErrorState.value = null
        passwordErrorState.value = null
        emailValidationTriggered.value = false
        passwordValidationTriggered.value = false
    }

    /**
     * Resets the UI state back to Initial
     */
    fun resetState() {
        _state.value = LoginContract.States.Initial
        _events.value = LoginContract.Events.Initial
        clearErrors()
    }

    /**
     * Handles email input changes
     * Clears error immediately when user types
     * Performs live validation after first validation attempt
     */
    fun onEmailChanged(email: String) {
        emailState.value = email
        // Clear error immediately when user types
        emailErrorState.value = null

        // Perform live validation only if validation was triggered before
        if (emailValidationTriggered.value) {
            val error = ValidationUtils.validateEmail(email.trim())
            emailErrorState.value = error
        }
    }

    /**
     * Handles password input changes
     * Clears error immediately when user types
     * Performs live validation after first validation attempt
     */
    fun onPasswordChanged(password: String) {
        passwordState.value = password
        // Clear error immediately when user types
        passwordErrorState.value = null

        // Perform live validation only if validation was triggered before
        if (passwordValidationTriggered.value) {
            val error = ValidationUtils.validateLoginPassword(password)
            passwordErrorState.value = error
        }
    }


}





