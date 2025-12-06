package com.route.e_commerce.screens.splash


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.route.e_commerce.R
import com.route.e_commerce.navigation.Routes
import com.route.e_commerce.ui.theme.WhiteWith40Opacity
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(modifier: Modifier = Modifier, navController: NavHostController,viewModel: SplashViewModel= hiltViewModel()) {
    val backgroundColor = MaterialTheme.colorScheme.primary
    val navigationState = viewModel.navigationState.value
    LaunchedEffect(Unit) {
        delay(2000)
        viewModel.navigate()
    }
    LaunchedEffect(navigationState) {
        navigationState?.let { direction ->
            navController.popBackStack(Routes.Splash.route, true)
            when (direction) {
                SplashDirections.Login -> navController.navigate(Routes.Login.route)
                SplashDirections.Home -> navController.navigate(Routes.Main.route)
            }
        }
    }
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(backgroundColor),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = modifier
                .weight(1f)
                .fillMaxHeight(.33f)
                .fillMaxWidth()
                .clip(RoundedCornerShape(bottomStartPercent = 100, bottomEndPercent = 100)) // Add this to control the shape
                .background(
                    brush = Brush.verticalGradient(
                        listOf(
                            WhiteWith40Opacity,
                            Color.Transparent
                        )
                    )
                )
        )
        Image(
            painter = painterResource(id = R.drawable.route_logo),
            contentDescription = stringResource(
                R.string.application_splash_logo
            ),
            modifier = modifier
                .weight(1f)
                .fillMaxWidth(.6f), contentScale = ContentScale.FillWidth
        )
        Box(
            modifier = modifier
                .weight(1F)
                .fillMaxHeight(.33f)
                .fillMaxWidth()
                .clip(RoundedCornerShape(topStartPercent = 100, topEndPercent = 100)) // Add this to control the shape
                .background(
                    brush = Brush.verticalGradient(
                        listOf(
                            Color.Transparent,
                            WhiteWith40Opacity
                        )
                    )
                )
        )

    }

}

@Preview
@Composable
private fun SplashPrev() {
    SplashScreen( navController = NavHostController(LocalContext.current))
    
}