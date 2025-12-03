package com.route.e_commerce.utils.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun AuthButton(
    modifier: Modifier = Modifier, text: String, onClick: () -> Unit, enabled: Boolean = true
) {
    val scheme = MaterialTheme.colorScheme
    Button(onClick = onClick, modifier = modifier.fillMaxWidth(), enabled = enabled
        , colors = ButtonDefaults.buttonColors(
            containerColor = scheme.secondary,
            contentColor = scheme.primary,
        ), shape = RoundedCornerShape(15.dp)) {
        Text(modifier = modifier.padding(vertical = 9.dp),text = text, color = scheme.primary, fontSize = 20.sp, fontWeight = FontWeight.W600)
    }


}

