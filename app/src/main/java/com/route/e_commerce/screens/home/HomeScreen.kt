package com.route.e_commerce.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.route.e_commerce.screens.home.components.BannerSlider

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    val scheme = MaterialTheme.colorScheme
    Column(
        modifier = modifier.padding(
            horizontal = 16.dp
        ),
        horizontalAlignment = Alignment.Start
    ) {
        BannerSlider()

    }

}

@Preview
@Composable
private fun BannerSliderPreview() {
    BannerSlider()
}
