package com.route.e_commerce.navigation

import androidx.annotation.DrawableRes
import com.route.e_commerce.R

data class BottomNavItem(
    val label: String,
    val route: String,
    @get:DrawableRes val icon: Int,
    @get:DrawableRes val filledIcon: Int
)

val bottomNavItems = listOf(
    BottomNavItem(
        label = "Home",
        route = BottomRoutes.Home.route,
        icon = R.drawable.ic_home,
        filledIcon = R.drawable.ic_home_selected
    ),
    BottomNavItem(
        label = "Categories",
        route = BottomRoutes.Categories.route,
        icon = R.drawable.ic_category,
        filledIcon = R.drawable.ic_category_selected
    ),
    BottomNavItem(
        label = "WishList",
        route = BottomRoutes.WishList.route,
        icon = R.drawable.ic_wish_list,
        filledIcon = R.drawable.ic_wish_list_selected
    ),
    BottomNavItem(
        label = "Account",
        route = BottomRoutes.Account.route,
        icon = R.drawable.ic_account,
        filledIcon = R.drawable.ic_account_selected
    )
)