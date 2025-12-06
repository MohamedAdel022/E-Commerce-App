package com.route.e_commerce.screens.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.route.e_commerce.screens.home.HomeContract
import com.route.e_commerce.screens.home.HomeViewModel

@Composable
fun CategoryListView(modifier: Modifier = Modifier, viewModel: HomeViewModel) {
    val state = viewModel.state.value.categoriesState

    when (state) {
        is HomeContract.ApiState.Idle, is HomeContract.ApiState.Loading -> {
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(10) {
                    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                        repeat(2) {
                            CategoryItemShimmer()
                        }
                    }
                }
            }
        }
        is HomeContract.ApiState.Error -> {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "Error: ${state.message}")
            }
        }
        is HomeContract.ApiState.Success -> {
            val categories = state.data?.filterNotNull() ?: emptyList()

            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(categories.chunked(2)) { chunk ->
                    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                        chunk.forEach { category ->
                            CategoryItem(
                                category = category,
                                onClick = {
                                    viewModel.handleIntent(
                                        HomeContract.Intent.CategoryClicked(category)
                                    )
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}

