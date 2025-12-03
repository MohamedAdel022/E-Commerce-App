package com.route.e_commerce.screens.register

import androidx.compose.runtime.State
import com.route.domin.entities.auth.AuthResponseEntity
import kotlinx.coroutines.flow.SharedFlow


class RegisterContract {
  sealed  interface  ViewModel{
        val state: State<UiState>
        val events: SharedFlow<Event>
        fun handleIntent(intent: Intent)
    }

    sealed interface UiState{
        data object Idle: UiState
        data object Loading: UiState
        data class Success(val authResponseEntity: AuthResponseEntity): UiState
        data class Error(val message: String): UiState
    }

    sealed interface Event{
        data object NavigateToHome: Event
        data object NavigateBackToLogin: Event
    }

    sealed interface Intent{
        data object RegisterClicked: Intent
        data object LoginClicked: Intent
    }


}