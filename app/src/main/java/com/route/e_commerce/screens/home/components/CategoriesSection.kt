package com.route.e_commerce.screens.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.route.e_commerce.screens.home.HomeViewModel

@Composable
fun CategoriesSection(modifier: Modifier = Modifier,viewModel: HomeViewModel) {
    val scheme = MaterialTheme.colorScheme
    Column(horizontalAlignment = Alignment.Start) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Categories", style = TextStyle(
                    fontSize = 18.sp,
                    fontWeight = FontWeight.W500,
                    color = scheme.primary
                )
            )

            Text(
                text = "view all", style = TextStyle(
                    fontSize = 12.sp,
                    fontWeight = FontWeight.W400,
                    color = scheme.primary
                )
            )
        }
        Spacer(modifier = Modifier.padding(8.dp))
        CategoryListView(viewModel = viewModel)

    }
}