package com.route.e_commerce.screens.categories.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.route.domin.entities.common.CategoryDataEntity
import com.route.e_commerce.ui.theme.Blue
import com.route.e_commerce.ui.theme.DarkBlue
import com.route.e_commerce.ui.theme.White


@Composable
 fun SelectedCategoryItem(
    category: CategoryDataEntity,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(90.dp)
            .background(White)
            .padding(start = 5.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Blue indicator bar on the left
        Box(
            modifier = Modifier
                .width(8.dp)
                .fillMaxHeight(.85f)
                .background(
                    color = Blue,
                    shape = androidx.compose.foundation.shape.RoundedCornerShape(8.dp)
                )
        )

        Text(
            text = category.name ?: "",
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium,
            color = DarkBlue,
            maxLines = 2,
            modifier = Modifier.padding(start = 16.dp)
        )
    }
}
