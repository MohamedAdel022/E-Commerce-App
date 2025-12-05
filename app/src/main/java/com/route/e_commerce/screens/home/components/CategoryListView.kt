package com.route.e_commerce.screens.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.route.e_commerce.R

@Composable
fun CategoryListView(modifier: Modifier = Modifier) {

    LazyRow() {
        items(10) {
            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                CategoryItem(onClick = {})
                CategoryItem(onClick = {})
            }
        }
    }
}

@Composable
fun CategoryItem(modifier: Modifier = Modifier, onClick: () -> Unit) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .width(90.dp)
            .clickable { onClick() },
    ) {
        Image(
            painter = painterResource(id = R.drawable.test_image),
            contentDescription = null,
            modifier = Modifier
                .size(80.dp)
                .clip(CircleShape),
            contentScale = ContentScale.Crop

        )
        Spacer(Modifier.height(3.dp))

        Text(
            text = "men’s\n" +
                    "fashion",
            fontSize = 14.sp,
            textAlign = TextAlign.Center,
            overflow = TextOverflow.Ellipsis
        )

    }
}