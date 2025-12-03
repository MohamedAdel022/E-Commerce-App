package com.route.e_commerce.screens.splash

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.route.domin.useCase.localStorage.GetTokenUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class SplashViewModel @Inject constructor(
    private val getTokenUseCase: GetTokenUseCase
) : ViewModel() {
    val navigationState = mutableStateOf<SplashDirections?>(null)

    fun navigate() {
        viewModelScope.launch {
            val token = getTokenUseCase.invoke()

            if (token.isNotEmpty()) {
                navigationState.value = SplashDirections.Home
            } else {
                navigationState.value = SplashDirections.Login
            }
        }
    }

}

enum class SplashDirections {
    Login,
    Home
}