package com.route.e_commerce.screens.categories.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.route.domin.entities.common.CategoryDataEntity

@Composable
fun CategoryListView(
    modifier: Modifier = Modifier,
    categories: List<CategoryDataEntity>,
    selectedCategoryId: String?,
    onItemClick: (CategoryDataEntity) -> Unit
) {
    LazyColumn(modifier = modifier) {
        items(categories) { category ->
            val isSelected = category.id == selectedCategoryId
            CategoryItem(
                category = category,
                isSelected = isSelected,
                onClick = { onItemClick(category) }
            )
        }
    }
}


