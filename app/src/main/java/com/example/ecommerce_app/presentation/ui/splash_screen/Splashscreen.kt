package com.example.ecommerce_app.presentation.splash
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.ecommerce_app.R
import kotlinx.coroutines.delay

@Composable
fun SplashScreen() {
    LaunchedEffect(Unit) {
        delay(2000)
     //   onNavigateNext() // نفذ أي شيء تم تمريره من الخارج
    }
Box ( modifier = Modifier.fillMaxSize()){
    Image(
        painter = painterResource(id = R.drawable.splash_screen),
        contentDescription = "App Logo",
        modifier = Modifier.fillMaxWidth().fillMaxHeight(),
        contentScale = ContentScale.Crop


    )
}







}

@Preview
@Composable
fun PreviewSplashScreen(){
    SplashScreen()
}