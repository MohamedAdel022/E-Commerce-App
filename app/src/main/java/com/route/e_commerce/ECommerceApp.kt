package com.route.e_commerce

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.route.e_commerce.navigation.AppNavHost

@Composable
fun ECommerceApp(modifier: Modifier) {
    val navController = rememberNavController()
    AppNavHost(navController = navController, modifier = modifier)
}