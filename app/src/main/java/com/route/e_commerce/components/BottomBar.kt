package com.route.e_commerce.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.route.e_commerce.navigation.BottomRoutes
import com.route.e_commerce.navigation.Graphs
import com.route.e_commerce.navigation.bottomNavItems

@Composable
fun BottomBar(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    val scheme = MaterialTheme.colorScheme
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    Surface(
        color = scheme.primary,
        shape = RoundedCornerShape(15.dp),
        modifier = modifier
            .fillMaxWidth()
            .height(70.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {

            bottomNavItems.forEach { item ->

                val selected = when (item.route) {
                    BottomRoutes.Categories.createRoute() ->
                        currentDestination?.hierarchy
                            ?.any { it.route == Graphs.CATEGORIES } == true

                    else ->
                        currentDestination?.hierarchy
                            ?.any { it.route == item.route } == true
                }

                Box(
                    modifier = Modifier
                        .size(45.dp)
                        .clip(CircleShape)
                        .background(if (selected) Color.White else Color.Transparent)
                        .clickable(
                            onClick = {
                                if (!selected) {
                                    navController.navigate(item.route) {
                                        launchSingleTop = true
                                        popUpTo(BottomRoutes.Home.route) {
                                            saveState = true
                                        }
                                        restoreState = true
                                    }
                                }
                            },
                            indication = null,
                            interactionSource = remember { MutableInteractionSource() }
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        painter = painterResource(
                            id = if (selected) item.filledIcon else item.icon
                        ),
                        contentDescription = item.label,
                        tint = if (selected) scheme.primary else Color.White,
                        modifier = Modifier.size(24.dp)
                    )
                }
            }
        }
    }
}
