package com.route.e_commerce.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed class Routes(val route: String) {
    @Serializable
    object Splash : Routes("splash_screen")
    @Serializable
    object Login : Routes("login_screen")
    @Serializable
    object Register : Routes("register_screen")
    @Serializable
    object Home : Routes("home_screen")

}