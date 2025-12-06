package com.route.e_commerce.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.route.e_commerce.navigation.BottomRoutes
import com.route.e_commerce.screens.home.components.BannerSlider
import com.route.e_commerce.screens.home.components.CategoriesSection
import com.route.e_commerce.screens.home.components.ProductsSection

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = hiltViewModel(),
    navController: NavHostController
) {
    // Observe events for navigation
    ObserveEvents(viewModel, navController)
    val scrollState = rememberScrollState()

    Column(
        modifier = modifier.padding(
            horizontal = 16.dp
        ).verticalScroll(scrollState),
        horizontalAlignment = Alignment.Start
    ) {
        BannerSlider()
        Spacer(modifier = Modifier.padding(12.dp))
        CategoriesSection(viewModel = viewModel)
        Spacer(modifier = Modifier.padding(12.dp))
        ProductsSection(viewModel = viewModel)

    }

}


@Composable
fun ObserveEvents(viewModel: HomeViewModel, navController: NavHostController) {
    LaunchedEffect(Unit) {
        viewModel.events.collect { event ->
            when (event) {
                is HomeContract.Event.NavigateToCategory -> {
                    // TODO: Navigate to category detail screen
                    navController.navigate(BottomRoutes.Categories.route)

                }

            }
        }
    }
}


@Preview
@Composable
private fun BannerSliderPreview() {
    BannerSlider()
}
