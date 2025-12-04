package com.route.e_commerce.screens.main

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.route.e_commerce.components.BottomBar
import com.route.e_commerce.components.TopBar
import com.route.e_commerce.navigation.BottomRoutes
import com.route.e_commerce.navigation.MainNavHost


@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    val bottomNavController = rememberNavController()
    val navBackStackEntry by bottomNavController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    val showTopBar = currentRoute != BottomRoutes.Account.route

    Scaffold(
        topBar = {
            if (showTopBar) {
                TopBar(value = "", onValueChange = {}, onCartClick = {})
            }
        },
        bottomBar = {
            BottomBar(navController = bottomNavController)

        }
    ) { innerPadding ->
        MainNavHost(modifier = modifier.padding(innerPadding), navController = bottomNavController)

    }

}
