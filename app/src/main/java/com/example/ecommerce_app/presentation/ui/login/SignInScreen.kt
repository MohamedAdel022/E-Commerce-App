package com.example.ecommerce_app.presentation.ui.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ecommerce_app.R
import com.example.ecommerce_app.presentation.ui.components.CustomTextField
import com.example.ecommerce_app.ui.theme.EcommerceAppTheme

@Composable
fun SignInScreen() {
    Box(
        Modifier
            .fillMaxSize()
            .background(
                MaterialTheme.colorScheme.background
            )
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,

            ) {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "App Logo",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .height(250.dp)
                    .width(250.dp)
            )
            Text("Welcome Back To Route", color = Color.White, modifier = Modifier.fillMaxWidth().padding(vertical = 15.dp, horizontal = 10.dp), fontSize = 24.sp, fontWeight = FontWeight.Bold,
               )

            Text("Please sign in with your email", color = Color.White, modifier = Modifier.fillMaxWidth().padding(vertical = 15.dp, horizontal = 10.dp), fontSize = 20.sp,)
            CustomTextField("Please enter your name", {  },"",false)
        }
    }
}

@Preview(showBackground = true)
@Composable

fun PreviewSignIn() {
    EcommerceAppTheme {
        SignInScreen()

    }


}