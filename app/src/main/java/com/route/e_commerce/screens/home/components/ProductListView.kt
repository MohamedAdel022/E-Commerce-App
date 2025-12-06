package com.route.e_commerce.screens.home.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.route.domin.entities.products.response.ProductDataItemEntity
import com.route.e_commerce.components.ProductCard

@Composable
fun ProductListView(
    products: List<ProductDataItemEntity>,
    cardHeight: Dp,
    modifier: Modifier = Modifier
) {
    LazyRow(
        modifier = modifier.height(cardHeight)
    ) {
        items(products.size) { index ->
            ProductCard(
                product = products[index],
                modifier = Modifier
                    .fillMaxHeight()
                    .aspectRatio(0.8f)
            )

            // Add spacing between cards, but not after the last one
            if (index < products.size - 1) {
                Spacer(modifier = Modifier.width(12.dp))
            }
        }
    }
}

