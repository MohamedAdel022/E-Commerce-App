package com.route.e_commerce.components

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier

@Composable
fun ECommerceAlertDialog(errorMessage: String, modifier: Modifier = Modifier) {
    val scheme = MaterialTheme.colorScheme
    val dialogState = remember {
        mutableStateOf(true)
    }
    if (dialogState.value) AlertDialog(onDismissRequest = {
        dialogState.value = false
    }, confirmButton = {
        TextButton(onClick = { dialogState.value = false }) {
            Text("OK")
        }
    }, text = {
        Text(errorMessage)
    }, containerColor = scheme.secondary, textContentColor = scheme.primary)
}