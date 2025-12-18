package com.route.e_commerce.screens.categories.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.route.e_commerce.components.shimmerEffect

@Composable
fun CategoryItemShimmer(
    modifier: Modifier = Modifier,
    isSelected: Boolean = false,

) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(90.dp)
            .padding(start = 5.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Left indicator (shimmered)
        if (isSelected) {
            Box(
                modifier = Modifier
                    .width(8.dp)
                    .fillMaxHeight(.85f)
                    .shimmerEffect(RoundedCornerShape(8.dp))
            )
        } else {
            // keep the same space when not selected so layout doesn't jump
            Box(
                modifier = Modifier
                    .width(8.dp)
                    .fillMaxHeight(.85f)
            )
        }

        // Main text placeholders (two lines)
        Box(
            modifier = Modifier
                .padding(start = 16.dp)
                .fillMaxWidth(0.6f)
                .height(16.dp)
                .shimmerEffect(RoundedCornerShape(4.dp))
        )
    }
}

