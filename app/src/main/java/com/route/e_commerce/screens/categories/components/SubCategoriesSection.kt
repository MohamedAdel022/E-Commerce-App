package com.route.e_commerce.screens.categories.components

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.route.e_commerce.screens.categories.CategoriesContract
import com.route.e_commerce.screens.categories.CategoriesViewModel

@Composable
fun SubCategoriesSection(modifier: Modifier = Modifier, viewmodel: CategoriesViewModel) {
    val state = viewmodel.state.value

    when (val subCategoryState = state.subCategoriesState) {
        is CategoriesContract.ApiState.Loading, is CategoriesContract.ApiState.Idle -> {
            // Show shimmer placeholders while loading
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = modifier
                    .padding(16.dp)
                    .fillMaxSize(),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                // show a fixed number of placeholders (adjust count as needed)
                items(10) {
                    SubCategoryItemShimmer()
                }
            }
        }

        is CategoriesContract.ApiState.Success -> {
            val subCategories = subCategoryState.data?.filterNotNull() ?: emptyList()
            SubCategoriesGrid(
                modifier = modifier,
                categories = subCategories,
            ) { subCategory ->
               viewmodel.handleIntent(CategoriesContract.Intent.SubCategoryClicked(subCategory))
            }
        }

        else -> {
            SubCategoriesGrid(
                modifier = modifier,
                categories = emptyList(),
            ) { }
        }
    }
}