package com.route.e_commerce.screens.login

import androidx.compose.runtime.State
import com.route.domin.entities.auth.AuthResponseEntity

class LoginContract {
   sealed interface  ViewModel{
        val states: State<States>
        val events: State<Events>
        fun handleIntent(intent: Intent)
    }
    sealed interface  Events{
        data object Initial: Events
        data object NavigateToHome: Events
        data object NavigateToRegister: Events
        data object ShowLoading: Events
        data class ShowError(val message: String): Events
    }
    sealed interface  Intent{
        data object Initial: Intent
        data object LoginClicked: Intent
        data object RegisterClicked: Intent
    }

    sealed interface  States{
        data object Initial: States
        data object Loading: States
        data class Success(val authResponseEntity: AuthResponseEntity): States
        data class Error(val message: String): States
    }

}