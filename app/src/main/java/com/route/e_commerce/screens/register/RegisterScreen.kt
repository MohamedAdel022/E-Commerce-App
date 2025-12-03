package com.route.e_commerce.screens.register

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.route.e_commerce.R
import com.route.e_commerce.components.ECommerceAlertDialog
import com.route.e_commerce.components.ECommerceLoadingIndecator
import com.route.e_commerce.components.PrettyToast
import com.route.e_commerce.components.ToastState
import com.route.e_commerce.components.rememberToastState
import com.route.e_commerce.components.showSuccess
import com.route.e_commerce.navigation.Routes
import com.route.e_commerce.screens.register.components.AlreadyHaveAccountSection
import com.route.e_commerce.ui.theme.ECommerceTheme
import com.route.e_commerce.utils.component.AuthButton
import com.route.e_commerce.utils.component.AuthTextField

@Composable
fun RegisterScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    viewModel: RegisterViewModel = hiltViewModel()
) {
    val scheme = MaterialTheme.colorScheme
    val scrollState = rememberScrollState()
    val toastState = rememberToastState()

    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier
                .fillMaxSize()
                .background(
                    color = scheme.primary
                )
                .verticalScroll(scrollState)
                .padding(horizontal = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier.padding(vertical = 33.dp))
            Image(
                modifier = modifier.fillMaxWidth(.6f),
                painter = painterResource(R.drawable.route_logo),
                contentDescription = "Route Logo",
                contentScale = ContentScale.Crop
            )
            Spacer(modifier.padding(vertical = 16.dp))
            AuthTextField(
                modifier = modifier,
                label = "Full Name",
                hint = "Enter your Full Name",
                state = viewModel.fullNameState,
                error = viewModel.fullNameErrorState.value,
                onValueChange = { viewModel.onFullNameChange(it) },
            )
            Spacer(modifier.padding(vertical = 10.dp))
            AuthTextField(
                modifier = modifier,
                label = "Mobile Number",
                hint = "Enter your Mobile Number",
                keyboardType = KeyboardType.Phone,
                state = viewModel.mobileNumberState,
                error = viewModel.mobileNumberErrorState.value,
                onValueChange = { viewModel.onMobileNumberChange(it) },
            )
            Spacer(modifier.padding(vertical = 10.dp))
            AuthTextField(
                modifier = modifier,
                label = "E-mail address",
                hint = "Enter your E-mail address",
                keyboardType = KeyboardType.Email,
                state = viewModel.emailState,
                error = viewModel.emailErrorState.value,
                onValueChange = { viewModel.onEmailChange(it) },
            )
            Spacer(modifier.padding(vertical = 10.dp))
            AuthTextField(
                modifier = modifier,
                label = "Password",
                hint = "Enter your Password",
                keyboardType = KeyboardType.Password,
                state = viewModel.passwordState,
                error = viewModel.passwordErrorState.value,
                onValueChange = { viewModel.onPasswordChange(it) },
                isPassword = true
            )
            Spacer(modifier.padding(vertical = 24.dp))
            AuthButton(
                text = "Sign up",
                onClick = {
                    viewModel.handleIntent(RegisterContract.Intent.RegisterClicked)
                },
            )
            Spacer(modifier.padding(vertical = 10.dp))
            AlreadyHaveAccountSection(
                modifier = modifier.align(Alignment.CenterHorizontally),
                navController = navController
            )
        }

        // Observe one-time events for navigation
        ObserveEvents(viewModel, navController)

        // Observe state for UI rendering
        RenderState(viewModel, toastState)

        // Add PrettyToast at the end
        PrettyToast(toastState = toastState)
    }
}

@Composable
fun ObserveEvents(viewModel: RegisterViewModel, navController: NavHostController) {
    LaunchedEffect(Unit) {
        viewModel.events.collect { event ->
            when (event) {
                RegisterContract.Event.NavigateBackToLogin -> {
                    navController.popBackStack()
                }
                RegisterContract.Event.NavigateToHome -> {
                    navController.navigate(Routes.Home.route) {
                        // Clear the entire back stack up to and including Login
                        popUpTo(0) {
                            inclusive = true
                        }
                        // Avoid multiple copies of the same destination
                        launchSingleTop = true
                    }
                    viewModel.resetState()
                }
            }
        }
    }
}


@Composable
fun RenderState(viewModel: RegisterViewModel, toastState: ToastState) {
    when (val state = viewModel.state.value) {
        RegisterContract.UiState.Idle -> {
            // Initial state - do nothing
        }

        RegisterContract.UiState.Loading -> {
            ECommerceLoadingIndecator()
        }

        is RegisterContract.UiState.Success -> {
            toastState.showSuccess("Account created successfully!")
        }

        is RegisterContract.UiState.Error -> {
            ECommerceAlertDialog(errorMessage = state.message)
        }
    }

}


@Preview(showBackground = true)
@Composable
private fun RegisterScreenPreview() {
    ECommerceTheme {
        RegisterScreen(navController = NavHostController(LocalContext.current))
    }


}