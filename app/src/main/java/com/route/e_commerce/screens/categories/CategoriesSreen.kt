package com.route.e_commerce.screens.categories

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import coil3.compose.AsyncImage
import com.route.e_commerce.screens.home.HomeViewModel

@Composable
fun CategoriesScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = hiltViewModel()
) {
    AsyncImage(
        model = "https://ecommerce.routemisr.com/Route-Academy-categories/1681511818071.jpeg",
        contentDescription = "",
        modifier = Modifier,
        contentScale = ContentScale.Crop
    )
    Text("hello")

}