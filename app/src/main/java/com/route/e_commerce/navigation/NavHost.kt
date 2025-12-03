package com.route.e_commerce.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.route.e_commerce.screens.home.HomeScreen
import com.route.e_commerce.screens.login.LoginScreen
import com.route.e_commerce.screens.register.RegisterScreen
import com.route.e_commerce.screens.splash.SplashScreen

@Composable
fun AppNavHost(navController: NavHostController,modifier: Modifier) {
    NavHost(navController = navController, startDestination =Routes.Splash.route, modifier = modifier) {
        composable(Routes.Splash.route){
            SplashScreen(navController=navController)

        }
        composable(Routes.Login.route) {
            LoginScreen(navController=navController)
        }
        composable(Routes.Register.route) {
            RegisterScreen( navController=navController)

        }
        composable(Routes.Home.route) {
            HomeScreen( navController=navController)

        }
    }
    
}