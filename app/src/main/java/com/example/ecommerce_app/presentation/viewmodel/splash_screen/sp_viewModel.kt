package com.example.ecommerce_app.presentation.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class SplashViewModel : ViewModel() {

    private val _isSplashDone = MutableStateFlow(false)
    val isSplashDone = _isSplashDone.asStateFlow()

    init {
        viewModelScope.launch {
            delay(2000)  // انتظر ثانيتين
            _isSplashDone.value = true
        }
    }
}
