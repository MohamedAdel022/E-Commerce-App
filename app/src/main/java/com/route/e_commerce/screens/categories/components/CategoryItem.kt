package com.route.e_commerce.screens.categories.components

import androidx.compose.runtime.Composable
import com.route.domin.entities.common.CategoryDataEntity

@Composable
fun CategoryItem(
    category: CategoryDataEntity,
    isSelected: Boolean,
    onClick: (CategoryDataEntity) -> Unit
) {
    if (isSelected) {
        SelectedCategoryItem(
            category = category,
            onClick = { onClick(category) }
        )
    } else {
        UnselectedCategoryItem(
            category = category,
            onClick = { onClick(category) }
        )
    }
}