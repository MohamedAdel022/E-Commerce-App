package com.route.e_commerce.screens.categories.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import com.route.domin.entities.common.CategoryDataEntity
import com.route.e_commerce.screens.categories.CategoriesContract
import com.route.e_commerce.screens.categories.CategoriesViewModel
import com.route.e_commerce.screens.home.HomeContract
import com.route.e_commerce.screens.home.HomeViewModel

@Composable
fun CategoriesListSection(
    modifier: Modifier = Modifier,
    homeViewModel: HomeViewModel,
    categoriesViewModel: CategoriesViewModel,
    onCategoryClick: (CategoryDataEntity) -> Unit = {}
) {
    val homeState = homeViewModel.state.value
    val selectedCategoryId = categoriesViewModel.selectedCategoryId

    val categories = when (val categoriesState = homeState.categoriesState) {
        is HomeContract.ApiState.Success ->
            categoriesState.data?.filterNotNull() ?: emptyList()
        else -> emptyList()
    }

    LaunchedEffect(homeState.categoriesState) {
        if (homeState.categoriesState is HomeContract.ApiState.Success) {
            categoriesViewModel.onCategoriesLoaded(categories)
        }
    }

    when (homeState.categoriesState) {
        is HomeContract.ApiState.Loading -> {
            LazyColumn {
                items(10) { index ->
                    CategoryItemShimmer(isSelected = index == 0)
                }
            }
        }
        else -> {
            CategoryListView(
                modifier = modifier,
                categories = categories,
                selectedCategoryId = selectedCategoryId,
                onItemClick = { category ->
                    categoriesViewModel.handleIntent(
                        CategoriesContract.Intent.CategoryClicked(category.id!!)
                    )
                    onCategoryClick(category)
                }
            )
        }
    }
}





