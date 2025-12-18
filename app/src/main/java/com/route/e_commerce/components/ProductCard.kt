package com.route.e_commerce.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.route.domin.entities.products.response.ProductDataItemEntity
import com.route.e_commerce.R
import com.route.e_commerce.ui.theme.Blue
import com.route.e_commerce.ui.theme.BlueWith30Opacity
import com.route.e_commerce.ui.theme.White
import com.route.e_commerce.utils.PriceUtils

@Composable
fun ProductCard(
    product: ProductDataItemEntity,
    modifier: Modifier = Modifier,
    onProductClick: () -> Unit = {},
    onFavoriteClick: () -> Unit = {}
) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = White
        ),
        border = BorderStroke(
            width = 1.dp,
            color = BlueWith30Opacity
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 2.dp
        ),
        onClick = onProductClick
    ) {
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            // Image section with favorite button
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1.5f) // Wider than tall - leaves room for text content
            ) {
                AsyncImage(
                    model = product.imageCover,
                    contentDescription = product.title,
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(1.5f)
                        .clip(RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)),
                    contentScale = ContentScale.Inside
                )

                // Favorite button
                Box(
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(4.dp)
                        .size(32.dp)
                        .clip(CircleShape)
                        .background(White)
                ) {
                    IconButton(
                        onClick = onFavoriteClick,
                        modifier = Modifier.size(32.dp)
                    ) {
                        Icon(
                             painter = painterResource(R.drawable.ic_wish_list_selected),
                            contentDescription = "Add to favorites",
                            tint = Blue,
                            modifier = Modifier.size(20.dp)
                        )
                    }
                }
            }

            // Content below image with padding
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .padding(horizontal = 6.dp, vertical = 4.dp),
                verticalArrangement = Arrangement.SpaceAround
            ) {
                // Title
                Text(
                    text = product.title ?: "",
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Normal,
                        color = Blue,
                        fontFamily = FontFamily(Font(R.font.poppins_medium))
                    ),
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )




                // Price and rating row
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // Price section
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        // Determine which price to show as main price
                        val displayPrice = product.priceAfterDiscount?.takeIf { it > 0 } ?: product.price
                        val hasDiscount = product.priceAfterDiscount != null &&
                                         product.priceAfterDiscount!! > 0 &&
                                         product.priceAfterDiscount!! < (product.price ?: 0)

                        // Main price (discounted price if available, otherwise regular price)
                        Text(
                            text = PriceUtils.formatPriceWithCurrency(displayPrice),
                            style = TextStyle(
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Medium,
                                color = Blue
                            )
                        )

                        // Show original price with strikethrough if there's a discount
                        if (hasDiscount) {
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = "${PriceUtils.formatPrice(product.price)} EGP",
                                style = TextStyle(
                                    fontSize = 10.sp,
                                    fontWeight = FontWeight.Normal,
                                    color = Blue.copy(alpha = 0.6f),
                                    textDecoration = TextDecoration.LineThrough
                                )
                            )
                        }
                    }
                }



                // Review and add to cart button row
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                // Review section
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Review ",
                        style = TextStyle(
                            fontSize = 12.sp,
                            fontWeight = FontWeight.W400,
                            color = Blue
                        )
                    )
                    Text(
                        text = "(${product.ratingsAverage ?: 0})",
                        style = TextStyle(
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Normal,
                            color = Blue
                        )
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = "⭐",
                        style = TextStyle(
                            fontSize = 12.sp
                        )
                    )
                }

                // Add to cart button
                Box(
                    modifier = Modifier
                        .size(32.dp)
                        .clip(CircleShape)
                        .background(Blue),
                    contentAlignment = Alignment.Center
                ) {
                    IconButton(
                        onClick = { /* Add to cart action */ },
                        modifier = Modifier.size(36.dp)
                    ) {
                        Text(
                            text = "+",
                            style = TextStyle(
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Normal,
                                color = White
                            )
                        )
                    }
                }

            }


            }  // Close inner Column (text content)
        }  // Close outer Column
    }  // Close Card
}

@Preview(showBackground = true, widthDp = 200)
@Composable
 fun ProductCardPreview() {
    MaterialTheme {
        ProductCard(
            product = ProductDataItemEntity(
                title = "Nike Air Jordon",
                description = "Nike shoes flexible for wo..",
                price = 1000,
                priceAfterDiscount = 1300,
                ratingsAverage = 4.8,
                imageCover = ""
            ),
            modifier = Modifier.width(191.dp)
        )
    }
}

