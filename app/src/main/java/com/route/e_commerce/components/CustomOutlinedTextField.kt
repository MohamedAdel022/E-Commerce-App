package com.route.e_commerce.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.route.e_commerce.R
import com.route.e_commerce.ui.theme.BlueWith60Opacity

@Composable
fun CustomOutlinedTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    placeholder: String = "what do you search for?"
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        leadingIcon = {
            Icon(
                modifier = Modifier
                    .size(48.dp)
                    .padding(start = 24.dp),
                painter = painterResource(id = R.drawable.ic_search),
                contentDescription = "search",
                tint = Color(0xFF0A4B8F)
            )
        },
        placeholder = {
            Text(
                text = placeholder,
                color = BlueWith60Opacity,
                fontFamily = FontFamily(Font(R.font.poppins_medium))
            )
        },
        shape = RoundedCornerShape(50),   // Pill shaped
        singleLine = true,
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = Color(0xFF0A4B8F),
            unfocusedBorderColor = Color(0xFF0A4B8F),
            cursorColor = Color(0xFF0A4B8F)
        ),
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
private fun CustomOutlinedTextFieldPreview() {
    CustomOutlinedTextField(
        value = "",
        onValueChange = {}
    )
}

