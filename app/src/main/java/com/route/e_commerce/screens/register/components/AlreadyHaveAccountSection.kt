package com.route.e_commerce.screens.register.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.route.e_commerce.R

@Composable
fun AlreadyHaveAccountSection(modifier: Modifier, navController: NavHostController ) {
    val scheme = MaterialTheme.colorScheme
    Row(
        modifier = modifier
    ) {
        Text(
            text = "Already have an account? ",
            style = TextStyle(
                color = scheme.secondary,
                fontFamily = FontFamily(Font(R.font.poppins_medium)),
                fontSize = 18.sp,
                fontWeight = FontWeight.W400
            )
        )
        Text(
            text = "Login",
            modifier = Modifier.clickable {
                navController.popBackStack()
            },
            style = TextStyle(
                color = scheme.secondary,
                fontFamily = FontFamily(Font(R.font.poppins_medium)),
                fontSize = 18.sp,
                fontWeight = FontWeight.W600
            )
        )
    }

}

