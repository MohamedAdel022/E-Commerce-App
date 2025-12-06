package com.route.e_commerce.screens.home.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalWindowInfo
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.route.e_commerce.screens.home.HomeContract
import com.route.e_commerce.screens.home.HomeViewModel

@Composable
fun ProductsSection(viewModel: HomeViewModel) {
    val scheme = MaterialTheme.colorScheme
    val windowInfo = LocalWindowInfo.current
    val density = LocalDensity.current
    val screenHeight = with(density) { windowInfo.containerSize.height.toDp() }
    val cardHeight = screenHeight * 0.23f
    val state = viewModel.state.value.productsState

    Column(
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = "Products",
            style = TextStyle(
                fontSize = 18.sp,
                fontWeight = FontWeight.W500,
                color = scheme.primary
            )
        )
        Spacer(modifier = Modifier.height(8.dp))
        when(state){
            HomeContract.ApiState.Idle, HomeContract.ApiState.Loading -> {
                ProductListShimmer(cardHeight = cardHeight)
            }
            is HomeContract.ApiState.Success-> {
                val products = state.data?.filterNotNull()?.shuffled() ?: emptyList()
                ProductListView(
                    products = products,
                    cardHeight = cardHeight
                )
            }
            is HomeContract.ApiState.Error -> {}
        }
    }

}