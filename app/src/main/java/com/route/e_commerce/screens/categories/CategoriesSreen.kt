package com.route.e_commerce.screens.categories

import android.util.Log
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.route.e_commerce.screens.categories.components.CategoriesListSection
import com.route.e_commerce.screens.categories.components.SubCategoriesSection
import com.route.e_commerce.screens.home.HomeViewModel

@Composable
fun CategoriesScreen(
    modifier: Modifier,
    homeViewModel: HomeViewModel = hiltViewModel(),
    categoriesViewModel: CategoriesViewModel = hiltViewModel(),
    selectedCategoryId: String?
) {
    LaunchedEffect(Unit) {
        Log.d("CategoriesScreen", "selectedCategoryId: $selectedCategoryId")
    }
    Row(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        verticalAlignment = Alignment.Top
    ) {
        CategoriesListWithBorder(
            homeViewModel = homeViewModel,
            categoriesViewModel = categoriesViewModel,
            modifier = Modifier
                .weight(.35f)
                .fillMaxHeight()
        )

        SubCategoriesSection(
            modifier = Modifier
                .weight(.65f)
                .fillMaxHeight()
        )
    }
}

@Composable
private fun CategoriesListWithBorder(
    homeViewModel: HomeViewModel,
    modifier: Modifier = Modifier,

    categoriesViewModel: CategoriesViewModel
) {
    Box(modifier = modifier) {
        CategoriesListSection(
            homeViewModel = homeViewModel,
            categoriesViewModel = categoriesViewModel,
            modifier = Modifier
                .matchParentSize()
                .clip(RoundedCornerShape(topStart = 10.dp))
                .background(color = Color(0xffEEF2F6))
        )

        BorderCanvas(modifier = Modifier.matchParentSize())
    }
}

@Composable
private fun BorderCanvas(modifier: Modifier = Modifier) {
    Canvas(modifier = modifier) {
        val borderColor = Color(0xffA7BDD4)
        val borderWidth = 1.dp.toPx()
        val cornerRadius = 10.dp.toPx()

        val path = Path().apply {
            // Start from bottom left
            moveTo(borderWidth / 2, size.height)
            // Draw left border up to where arc begins
            lineTo(borderWidth / 2, cornerRadius + borderWidth / 2)
            // Draw the rounded corner arc
            arcTo(
                rect = Rect(
                    left = borderWidth / 2,
                    top = borderWidth / 2,
                    right = cornerRadius * 2 + borderWidth / 2,
                    bottom = cornerRadius * 2 + borderWidth / 2
                ),
                startAngleDegrees = 180f,
                sweepAngleDegrees = 90f,
                forceMoveTo = false
            )
            // Draw top border to the right edge
            lineTo(size.width, borderWidth / 2)
        }

        drawPath(
            path = path,
            color = borderColor,
            style = Stroke(width = borderWidth)
        )
    }
}



