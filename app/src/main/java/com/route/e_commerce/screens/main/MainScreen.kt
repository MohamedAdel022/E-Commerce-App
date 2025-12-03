package com.route.e_commerce.screens.main

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.route.e_commerce.navigation.MainNavHost
import com.route.e_commerce.utils.component.BottomBar


@Composable
fun MainScreen(modifier: Modifier = Modifier, navController: NavHostController) {
    val bottomNavController = rememberNavController()
    Scaffold(
        bottomBar = {
            BottomBar(navController = bottomNavController)

        }
    ) {innerPadding->
        MainNavHost(modifier = modifier.padding(innerPadding), navController = bottomNavController)

    }

}
