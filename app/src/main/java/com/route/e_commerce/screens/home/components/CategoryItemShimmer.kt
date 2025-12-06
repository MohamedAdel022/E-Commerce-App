package com.route.e_commerce.screens.home.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.route.e_commerce.components.shimmerEffect

@Composable
fun CategoryItemShimmer(
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .width(90.dp)
            .height(125.dp)
    ) {
        // Circular shimmer for image
        Box(
            modifier = Modifier
                .size(80.dp)
                .clip(CircleShape)
                .shimmerEffect(CircleShape)
        )

        Spacer(Modifier.height(8.dp))

        // Rectangular shimmer for text
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(36.dp)
                .clip(RoundedCornerShape(4.dp))
                .shimmerEffect(RoundedCornerShape(4.dp))
        )
    }
}

