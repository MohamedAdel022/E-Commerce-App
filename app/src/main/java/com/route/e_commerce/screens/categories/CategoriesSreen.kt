package com.route.e_commerce.screens.categories

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage

@Composable
fun CategoriesScreen(modifier: Modifier = Modifier) {
    AsyncImage(
        model = "https://ecommerce.routemisr.com/Route-Academy-categories/1681511818071.jpeg",
        contentDescription = "",
        modifier = Modifier,
        contentScale = ContentScale.Crop
    )
    Text("hello")

}