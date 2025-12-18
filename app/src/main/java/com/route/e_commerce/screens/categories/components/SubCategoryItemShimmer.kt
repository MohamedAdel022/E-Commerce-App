package com.route.e_commerce.screens.categories.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.route.e_commerce.components.shimmerEffect
import com.route.e_commerce.ui.theme.BlueWith30Opacity
import androidx.compose.foundation.layout.aspectRatio

@Composable
fun SubCategoryItemShimmer(
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Card(
            shape = RoundedCornerShape(5.dp),
            elevation = CardDefaults.cardElevation(4.dp),
            border = BorderStroke(width = 2.dp, color = BlueWith30Opacity),
            modifier = Modifier
                .width(85.dp)
                .aspectRatio(3.1f / 2.6f)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .shimmerEffect(RoundedCornerShape(5.dp))
            )
        }

        Spacer(modifier = Modifier.height(6.dp))

        Box(
            modifier = Modifier
                .width(60.dp)
                .height(12.dp)
                .shimmerEffect(RoundedCornerShape(4.dp))
        )
    }
}

