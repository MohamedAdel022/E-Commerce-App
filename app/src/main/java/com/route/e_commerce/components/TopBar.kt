package com.route.e_commerce.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.route.e_commerce.R
import com.route.e_commerce.ui.theme.Blue

@Composable
fun TopBar(
    value: String,
    onValueChange: (String) -> Unit,
    onCartClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val scheme = MaterialTheme.colorScheme

    Column(
        modifier = Modifier.padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.Start
    ) {
        Image(
            painter = painterResource(id = R.drawable.route_logo),
            contentDescription = "",
            colorFilter = ColorFilter.tint(scheme.primary)
        )
        Spacer(modifier = Modifier.padding(vertical = 8.dp))
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            // Search Input
            CustomOutlinedTextField(
                value = value,
                onValueChange = onValueChange,
                modifier = Modifier.weight(1f)
            )


            IconButton(onClick = onCartClick) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_cart), // your cart icon
                    contentDescription = "cart",
                    tint = Blue,
                    modifier = Modifier
                        .size(38.dp)
                        .padding(4.dp)
                )
            }
        }
    }


}

@Preview
@Composable
private fun TopBarPrev() {
    TopBar(value = "", onValueChange = {}, onCartClick = {})

}
