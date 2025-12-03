package com.route.e_commerce.screens.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.route.e_commerce.R
import com.route.e_commerce.components.ECommerceAlertDialog
import com.route.e_commerce.components.ECommerceLoadingIndecator
import com.route.e_commerce.navigation.Routes
import com.route.e_commerce.ui.theme.ECommerceTheme
import com.route.e_commerce.utils.component.AuthButton
import com.route.e_commerce.utils.component.AuthTextField

@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    viewModel: LoginViewModel = hiltViewModel()
) {
    val scheme = MaterialTheme.colorScheme
    Column(
        modifier
            .fillMaxSize()
            .background(
                color = scheme.primary
            )
            .padding(horizontal = 16.dp), horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier.padding(vertical = 33.dp))
        Image(
            modifier = modifier.fillMaxWidth(.6f),
            painter = painterResource(R.drawable.route_logo),
            contentDescription = "Route Logo",
            contentScale = ContentScale.Crop
        )
        Spacer(modifier.padding(vertical = 24.dp))

        Text(
            modifier = modifier.align(Alignment.Start),
            text = "Welcome Back To Route",
            style = TextStyle(
                color = scheme.secondary,
                fontFamily = FontFamily(Font(R.font.poppins_medium)),
                fontSize = 24.sp,
                fontWeight = FontWeight.W600
            )
        )
        Text(
            modifier = modifier.align(Alignment.Start),
            text = "Please sign in with your mail",
            style = TextStyle(
                color = scheme.secondary,
                fontFamily = FontFamily(Font(R.font.poppins_medium)),
                fontSize = 16.sp,
                fontWeight = FontWeight.W300
            )
        )
        Spacer(modifier.padding(vertical = 24.dp))
        AuthTextField(
            modifier = modifier,
            label = "Email",
            hint = "Enter your Email",
            keyboardType = KeyboardType.Email,
            state = viewModel.emailState,
            onValueChange = {
                viewModel.onEmailChanged(it)
            },
            error = viewModel.emailErrorState.value
        )
        Spacer(modifier.padding(vertical = 12.dp))

        AuthTextField(
            modifier = modifier,
            label = "Password",
            hint = "Enter your Password",
            keyboardType = KeyboardType.Password,

            state = viewModel.passwordState,
            onValueChange = {
                viewModel.onPasswordChanged(it)
            },
            isPassword = true,
            error = viewModel.passwordErrorState.value
        )


        Spacer(modifier.padding(vertical = 8.dp))
        Text(
            text = "Forgot password", modifier = modifier.align(Alignment.End), style = TextStyle(
                fontFamily = FontFamily(Font(R.font.poppins_medium)),
                fontSize = 18.sp,
                color = scheme.secondary,
                fontWeight = FontWeight.W400
            )
        )
        Spacer(modifier.padding(vertical = 24.dp))

        AuthButton(
            text = "Login",
            onClick = {
                viewModel.handleIntent(LoginContract.Intent.LoginClicked)
            },
        )

        Spacer(modifier.padding(vertical = 12.dp))

        Row(
            modifier = modifier.align(Alignment.CenterHorizontally)
        ) {
            Text(
                text = "Don't have an account? ", style = TextStyle(
                    color = scheme.secondary,
                    fontFamily = FontFamily(Font(R.font.poppins_medium)),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.W400
                )
            )
            Text(
                text = "Create Account", modifier = Modifier.clickable {
                    viewModel.handleIntent(LoginContract.Intent.RegisterClicked)
                }, style = TextStyle(
                    color = scheme.secondary,
                    fontFamily = FontFamily(Font(R.font.poppins_medium)),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.W600
                )
            )
        }

    }
    RenderStates(viewModel)
    TriggerEvent(viewModel, navController)


}

@Composable
fun TriggerEvent(viewModel: LoginViewModel, navController: NavHostController) {
    when (val event = viewModel.events.value) {
        LoginContract.Events.Initial -> {}
        LoginContract.Events.NavigateToHome -> {

            LaunchedEffect(Unit) {
                navController.popBackStack(Routes.Login.route, true)
                navController.navigate(Routes.Home.route)
            }
        }

        LoginContract.Events.NavigateToRegister -> {
            LaunchedEffect(Unit) {
                navController.navigate(Routes.Register.route)
                viewModel.resetState()
            }
        }

        is LoginContract.Events.ShowError -> {
            ECommerceAlertDialog(errorMessage = event.message)
        }

        LoginContract.Events.ShowLoading -> {
            ECommerceLoadingIndecator()
        }
    }
}

@Composable
fun RenderStates(viewModel: LoginViewModel) {
    val state = viewModel.states.value
    when (state) {
        is LoginContract.States.Error -> {

        }

        LoginContract.States.Initial -> {}
        LoginContract.States.Loading -> {

        }

        is LoginContract.States.Success -> {

        }
    }

}


@Preview(showBackground = true)
@Composable
private fun LoginScreenPreview() {
    ECommerceTheme {
        LoginScreen(navController = NavHostController(LocalContext.current))
    }


}