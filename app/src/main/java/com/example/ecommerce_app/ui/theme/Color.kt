package com.example.ecommerce_app.ui.theme

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color


private val LightColors = lightColorScheme(
background =  Color(0xFF004182)
)


private val DarkColors = darkColorScheme(

)

@Composable
fun EcommerceAppTheme(
    darkTheme: Boolean = false,
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) DarkColors else LightColors

    MaterialTheme(
        colorScheme = colors,
        typography = Typography, // إذا لديك Type.kt
        // إذا لديك Shape.kt
        content = content
    )
}
