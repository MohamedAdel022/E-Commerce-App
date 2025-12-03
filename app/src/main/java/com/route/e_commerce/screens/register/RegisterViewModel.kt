package com.route.e_commerce.screens.register

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.route.domin.base.Resource
import com.route.domin.entities.auth.request.RegisterRequestEntity
import com.route.domin.useCase.auth.RegisterUseCase
import com.route.domin.useCase.localStorage.SetTokenUseCase
import com.route.e_commerce.utils.ValidationUtils
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val registerUseCase: RegisterUseCase,
    private val setTokenUseCase: SetTokenUseCase
) : ViewModel(), RegisterContract.ViewModel {
    val fullNameState = mutableStateOf<String>("")
    val fullNameErrorState = mutableStateOf<String?>(null)
    private var hasFullNameBeenValidated = false

    val emailState = mutableStateOf<String>("")
    val emailErrorState = mutableStateOf<String?>(null)
    private var hasEmailBeenValidated = false

    val passwordState = mutableStateOf<String>("")
    val passwordErrorState = mutableStateOf<String?>(null)
    private var hasPasswordBeenValidated = false

    val mobileNumberState = mutableStateOf<String>("")
    val mobileNumberErrorState = mutableStateOf<String?>(null)
    private var hasMobileNumberBeenValidated = false

    private val _state: MutableState<RegisterContract.UiState> =
        mutableStateOf(RegisterContract.UiState.Idle)
    override val state: State<RegisterContract.UiState> = _state

    private val _events = MutableSharedFlow<RegisterContract.Event>()
    override val events: SharedFlow<RegisterContract.Event> = _events.asSharedFlow()

    override fun handleIntent(intent: RegisterContract.Intent) {
        when (intent) {
            RegisterContract.Intent.LoginClicked -> {
                viewModelScope.launch {
                    _events.emit(RegisterContract.Event.NavigateBackToLogin)
                }
            }

            RegisterContract.Intent.RegisterClicked -> {
                register()
            }
        }
    }

    fun register() {
        if (validateAllFields()) {
            viewModelScope.launch {
                _state.value = RegisterContract.UiState.Loading

                val response = registerUseCase.invoke(
                    RegisterRequestEntity(
                        name = fullNameState.value,
                        email = emailState.value,
                        password = passwordState.value,
                        rePassword = passwordState.value,
                        phone = mobileNumberState.value
                    )
                )

                when (response) {
                    is Resource.Success -> {
                        if (response.data != null) {
                            _state.value = RegisterContract.UiState.Success(response.data!!)
                            //TODO save token in Data Store
                            setTokenUseCase.invoke(response.data?.token?:"")

                            // Delay navigation to show toast
                          delay(1500L)
                            _events.emit(RegisterContract.Event.NavigateToHome)
                            resetForm()
                        }
                    }

                    is Resource.Failure -> {
                        _state.value = RegisterContract.UiState.Error(response.message)
                    }
                }
            }
        }
    }

    /**
     * Handles full name input change
     * Clears error on typing, validates live after first error
     */
    fun onFullNameChange(value: String) {
        fullNameState.value = value

        if (hasFullNameBeenValidated) {
            // Live validation after first error
            fullNameErrorState.value = ValidationUtils.validateFullName(value)
        } else {
            // Clear error while typing before first validation
            fullNameErrorState.value = null
        }
    }

    /**
     * Handles email input change
     * Clears error on typing, validates live after first error
     */
    fun onEmailChange(value: String) {
        emailState.value = value

        if (hasEmailBeenValidated) {
            // Live validation after first error
            emailErrorState.value = ValidationUtils.validateEmail(value)
        } else {
            // Clear error while typing before first validation
            emailErrorState.value = null
        }
    }

    /**
     * Handles password input change
     * Clears error on typing, validates live after first error
     */
    fun onPasswordChange(value: String) {
        passwordState.value = value

        if (hasPasswordBeenValidated) {
            // Live validation after first error
            passwordErrorState.value = ValidationUtils.validatePassword(value)
        } else {
            // Clear error while typing before first validation
            passwordErrorState.value = null
        }
    }

    /**
     * Handles mobile number input change
     * Clears error on typing, validates live after first error
     */
    fun onMobileNumberChange(value: String) {
        mobileNumberState.value = value

        if (hasMobileNumberBeenValidated) {
            // Live validation after first error
            mobileNumberErrorState.value = ValidationUtils.validateMobileNumber(value)
        } else {
            // Clear error while typing before first validation
            mobileNumberErrorState.value = null
        }
    }

    /**
     * Validates all fields
     * Called when user clicks Sign Up button
     * @return true if all fields are valid, false otherwise
     */
    fun validateAllFields(): Boolean {
        // Mark all fields as validated to enable live validation
        hasFullNameBeenValidated = true
        hasEmailBeenValidated = true
        hasPasswordBeenValidated = true
        hasMobileNumberBeenValidated = true

        // Validate all fields
        val fullNameError = ValidationUtils.validateFullName(fullNameState.value)
        val emailError = ValidationUtils.validateEmail(emailState.value)
        val passwordError = ValidationUtils.validatePassword(passwordState.value)
        val mobileNumberError = ValidationUtils.validateMobileNumber(mobileNumberState.value)

        // Update error states
        fullNameErrorState.value = fullNameError
        emailErrorState.value = emailError
        passwordErrorState.value = passwordError
        mobileNumberErrorState.value = mobileNumberError

        // Return true if all fields are valid
        return fullNameError == null &&
                emailError == null &&
                passwordError == null &&
                mobileNumberError == null
    }

    /**
     * Clears all error states
     * Useful when navigating away or resetting the form
     */
    fun clearAllErrors() {
        fullNameErrorState.value = null
        emailErrorState.value = null
        passwordErrorState.value = null
        mobileNumberErrorState.value = null

        hasFullNameBeenValidated = false
        hasEmailBeenValidated = false
        hasPasswordBeenValidated = false
        hasMobileNumberBeenValidated = false
    }

    /**
     * Resets all form fields and errors
     */
    fun resetForm() {
        fullNameState.value = ""
        emailState.value = ""
        passwordState.value = ""
        mobileNumberState.value = ""
        clearAllErrors()
    }

    /**
     * Resets the UI state back to Idle
     */
    fun resetState() {
        _state.value = RegisterContract.UiState.Idle
        clearAllErrors()
    }


}





