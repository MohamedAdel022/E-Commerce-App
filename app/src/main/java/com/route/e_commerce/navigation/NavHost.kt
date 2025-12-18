package com.route.e_commerce.navigation

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.navArgument
import com.route.e_commerce.screens.account.AccountScreen
import com.route.e_commerce.screens.categories.CategoriesScreen
import com.route.e_commerce.screens.categories.CategoriesViewModel
import com.route.e_commerce.screens.home.HomeScreen
import com.route.e_commerce.screens.home.HomeViewModel
import com.route.e_commerce.screens.login.LoginScreen
import com.route.e_commerce.screens.main.MainScreen
import com.route.e_commerce.screens.product.ProductScreen
import com.route.e_commerce.screens.register.RegisterScreen
import com.route.e_commerce.screens.splash.SplashScreen
import com.route.e_commerce.screens.wish_list.WishListScreen

@Composable
fun AppNavHost(navController: NavHostController,modifier: Modifier) {
    NavHost(navController = navController, startDestination =Routes.Splash.route, modifier = modifier)
    {
        composable(Routes.Splash.route){
            SplashScreen(navController=navController)

        }
        composable(Routes.Login.route) {
            LoginScreen(navController=navController)
        }
        composable(Routes.Register.route) {
            RegisterScreen( navController=navController)

        }
        composable(Routes.Main.route) {
            MainScreen( )

        }

    }
    
}


@Composable
fun MainNavHost(modifier: Modifier = Modifier, navController: NavHostController) {
    NavHost(navController = navController, startDestination = BottomRoutes.Home.route, modifier = Modifier){
        composable(
            route = BottomRoutes.Home.route,
            enterTransition = {
                slideIntoContainer(
                    towards = AnimatedContentTransitionScope.SlideDirection.Right,
                    animationSpec = tween(300)
                )
            },
            exitTransition = {
                slideOutOfContainer(
                    towards = AnimatedContentTransitionScope.SlideDirection.Left,
                    animationSpec = tween(300)
                )
            }
        ){backStackEntry->
            val parentEntry = remember(backStackEntry) {
                navController.getBackStackEntry(navController.graph.id)
            }

            val sharedViewModel: HomeViewModel = hiltViewModel(parentEntry)
            HomeScreen(modifier=modifier, viewModel = sharedViewModel, navController=navController)
        }
        navigation(
            route = Graphs.CATEGORIES,
            startDestination = BottomRoutes.Categories.route
        ) {

            composable(
                route = BottomRoutes.Categories.route,
                arguments = listOf(
                    navArgument("selectedId") {
                        type = NavType.StringType
                        nullable = true
                        defaultValue = null
                    }
                )
            ) { backStackEntry ->

                val parentEntry = remember(backStackEntry) {
                    navController.getBackStackEntry(navController.graph.id)
                }

                val homeViewModel: HomeViewModel = hiltViewModel(parentEntry)
                val categoriesViewModel: CategoriesViewModel =
                    hiltViewModel(parentEntry)

                CategoriesScreen(
                    modifier = modifier,
                    homeViewModel = homeViewModel,
                    categoriesViewModel = categoriesViewModel,
                    navController = navController
                )
            }

            composable(Routes.Product.route) {
                ProductScreen()
            }
        }
        composable(
            route = BottomRoutes.WishList.route,
            enterTransition = {
                slideIntoContainer(
                    towards = AnimatedContentTransitionScope.SlideDirection.Left,
                    animationSpec = tween(300)
                )
            },
            exitTransition = {
                slideOutOfContainer(
                    towards = AnimatedContentTransitionScope.SlideDirection.Right,
                    animationSpec = tween(300)
                )
            }
        ){
            WishListScreen()
        }
        composable(
            route = BottomRoutes.Account.route,
            enterTransition = {
                slideIntoContainer(
                    towards = AnimatedContentTransitionScope.SlideDirection.Left,
                    animationSpec = tween(300)
                )
            },
            exitTransition = {
                slideOutOfContainer(
                    towards = AnimatedContentTransitionScope.SlideDirection.Right,
                    animationSpec = tween(300)
                )
            }
        ){
            AccountScreen()
        }


    }
    
}