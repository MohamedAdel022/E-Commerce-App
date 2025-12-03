package com.route.e_commerce.utils.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.route.e_commerce.R
import com.route.e_commerce.ui.theme.BlackWith70Opacity

@Composable
fun AuthTextField(
    modifier: Modifier = Modifier,
    label: String,
    hint: String,
    error: String? = null,
    state: MutableState<String>,
    isPassword: Boolean = false,
    keyboardType: KeyboardType = KeyboardType.Text,
    onValueChange: (String) -> Unit
) {
    val scheme = MaterialTheme.colorScheme
    val passwordVisible = remember { mutableStateOf(false) }

    Column(modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            modifier = modifier.align(Alignment.Start),
            text = label,
            color = scheme.secondary,
            style = TextStyle(
                fontFamily = FontFamily(Font(R.font.poppins_medium)),
                fontWeight = FontWeight.W500,
                fontSize = 18.sp
            ),
        )
        Spacer(modifier.padding(vertical = 4.dp))
        TextField(
            modifier = modifier.fillMaxWidth(),
            value = state.value,
            onValueChange = {
                state.value = it
                onValueChange(it)
            },
            keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
            trailingIcon = {
                if (isPassword) {
                    IconButton(onClick = {
                        passwordVisible.value = !passwordVisible.value
                    }) {
                        Icon(
                            imageVector = if (passwordVisible.value)
                                Icons.Filled.Visibility
                            else
                                Icons.Filled.VisibilityOff,
                            contentDescription = if (passwordVisible.value)
                                "Hide password"
                            else
                                "Show password",
                            tint = scheme.onSecondary
                        )
                    }
                }
            },
            singleLine = true,
            visualTransformation = if (isPassword && !passwordVisible.value)
                PasswordVisualTransformation()
            else
                VisualTransformation.None,
            shape = RoundedCornerShape(15.dp),

            colors = TextFieldDefaults.colors(
                focusedTextColor = scheme.onSecondary,
                focusedPlaceholderColor = BlackWith70Opacity,
                unfocusedPlaceholderColor = BlackWith70Opacity,
                errorPlaceholderColor = BlackWith70Opacity,
                unfocusedTextColor = scheme.onSecondary,
                focusedContainerColor = scheme.secondary,
                unfocusedContainerColor = scheme.secondary,
                errorContainerColor = scheme.secondary,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent,
                errorIndicatorColor = Color.Transparent,
            ),

            placeholder = { Text(text = hint, color = BlackWith70Opacity) },
        )
        Spacer(modifier.padding(vertical = 2.dp))
        if (error != null) {
            Text(text = error, color = scheme.error, modifier = modifier.align(Alignment.Start), textAlign = TextAlign.Start)
        }
    }

}

@Preview
@Composable
private fun AuthTextFieldPrev() {
    AuthTextField(
        label = "Email",
        hint = "Enter your email",
        state = mutableStateOf(""),
        onValueChange = {}
    )
}