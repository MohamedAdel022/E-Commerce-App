package com.route.e_commerce.screens.categories.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.route.domin.entities.common.CategoryDataEntity
import com.route.e_commerce.R
import com.route.e_commerce.ui.theme.BlueWith30Opacity

@Composable
fun SubCategoryItem(
    category: CategoryDataEntity,
    onClick: (CategoryDataEntity) -> Unit
) {
    val scheme= MaterialTheme.colorScheme
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .clickable {
                onClick(category)
            }
    ) {

        Card(
            shape = RoundedCornerShape(5.dp),
            elevation = CardDefaults.cardElevation(4.dp),
            border = BorderStroke(
                width = 2.dp,
                color = BlueWith30Opacity
            ),
            modifier = Modifier
                .aspectRatio(3.1f / 2.6f)
        ) {
            Image(
                painter = painterResource(R.drawable.category_placeholder),
                contentDescription = "",
                contentScale = ContentScale.Fit,
                modifier = Modifier.fillMaxSize()
            )
        }

        Spacer(modifier = Modifier.height(6.dp))

        Text(
            text = category.name ?: "",
            fontSize = 12.sp,
            fontWeight = FontWeight.W400,
            color = scheme.onSurface,
            textAlign = TextAlign.Center
        )
    }
}
