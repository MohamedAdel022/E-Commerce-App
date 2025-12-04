package com.route.e_commerce.screens.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.route.e_commerce.R
import com.route.e_commerce.models.BannerItemData
import com.route.e_commerce.ui.theme.Blue


@Composable
fun BannerPage(item: BannerItemData, index: Int) {
    val isLeftAligned = index % 2 == 0
    val textColor = if (isLeftAligned) Blue else Color.White
    val alignment = if (isLeftAligned) Alignment.CenterStart else Alignment.CenterEnd

    Box(
        Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(item.image),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )


        Column(
            Modifier
                .align(alignment)
                .padding(16.dp),
        ) {
            Text(
                item.title, color = textColor, style = TextStyle(
                    fontFamily = FontFamily(Font(R.font.poppins_medium)),
                    fontSize = 22.sp,
                    fontWeight = FontWeight.W500
                )
            )

            Text(
                item.description, color = textColor, style = TextStyle(
                    fontFamily = FontFamily(Font(R.font.poppins_medium)),
                    fontSize = 14.sp,
                    fontWeight = FontWeight.W400
                )
            )
            Spacer(Modifier.height(4.dp))

            Button(
                shape = RoundedCornerShape(10.dp),
                onClick = { /* onClick */ }
            ) {
                Text("Shop Now")
            }
        }
    }
}