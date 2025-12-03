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
    object Main : Routes("main_screen")

}
@Serializable
sealed class BottomRoutes(val route: String) {
    @Serializable
    object Home : BottomRoutes("home_screen")
    @Serializable
    object Categories : BottomRoutes("categories_screen")
    @Serializable
    object WishList : BottomRoutes("wishlist_screen")
    @Serializable
    object Account : BottomRoutes("account_screen")
}