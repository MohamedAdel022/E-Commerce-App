package com.route.e_commerce.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog

@Composable
fun ECommerceLoadingIndecator(modifier: Modifier = Modifier) {
    val scheme = MaterialTheme.colorScheme
    Dialog(onDismissRequest = {}) {
        Box(
            Modifier
                .size(100.dp)
                .background(Color.White, RoundedCornerShape(8.dp)),
            contentAlignment = Alignment.Center,
        ) {
            CircularProgressIndicator(color = scheme.primary)
        }
    }
}