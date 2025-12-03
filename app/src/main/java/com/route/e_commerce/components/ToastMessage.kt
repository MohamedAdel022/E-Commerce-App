package com.route.e_commerce.components

import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay

enum class ToastType {
    SUCCESS,
    ERROR,
    INFO,
    WARNING
}

data class ToastData(
    val message: String,
    val type: ToastType = ToastType.INFO,
    val duration: Long = 3000L
)

class ToastState {
    var currentToast by mutableStateOf<ToastData?>(null)
        private set

    fun showToast(message: String, type: ToastType = ToastType.INFO, duration: Long = 3000L) {
        currentToast = ToastData(message, type, duration)
    }

    fun dismissToast() {
        currentToast = null
    }
}

@Composable
fun rememberToastState(): ToastState {
    return remember { ToastState() }
}

@Composable
fun PrettyToast(
    toastState: ToastState,
    modifier: Modifier = Modifier
) {
    val toast = toastState.currentToast

    LaunchedEffect(toast) {
        if (toast != null) {
            delay(toast.duration)
            toastState.dismissToast()
        }
    }

    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.BottomCenter
    ) {
        AnimatedVisibility(
            visible = toast != null,
            enter = slideInVertically(
                initialOffsetY = {
                    it },
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioMediumBouncy,
                    stiffness = Spring.StiffnessLow
                )
            ) + fadeIn(),
            exit = slideOutVertically(
                targetOffsetY = { it },
                animationSpec = tween(300)
            ) + fadeOut()
        ) {
            if (toast != null) {
                ToastContent(toast = toast)
            }
        }
    }
}

@Composable
private fun ToastContent(toast: ToastData) {
    val (backgroundColor, iconColor, icon) = when (toast.type) {
        ToastType.SUCCESS -> Triple(
            Color(0xFF4CAF50),
            Color.White,
            Icons.Default.CheckCircle
        )
        ToastType.ERROR -> Triple(
            Color(0xFFE53935),
            Color.White,
            Icons.Default.Error
        )
        ToastType.WARNING -> Triple(
            Color(0xFFFFA726),
            Color.White,
            Icons.Default.Warning
        )
        ToastType.INFO -> Triple(
            Color(0xFF2196F3),
            Color.White,
            Icons.Default.Info
        )
    }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .shadow(8.dp, RoundedCornerShape(12.dp)),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(
            containerColor = backgroundColor
        )
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = iconColor,
                modifier = Modifier.size(24.dp)
            )
            Text(
                text = toast.message,
                style = MaterialTheme.typography.bodyMedium,
                color = Color.White,
                modifier = Modifier.weight(1f)
            )
        }
    }
}

// Extension functions for easy toast usage
fun ToastState.showSuccess(message: String) {
    showToast(message, ToastType.SUCCESS)
}

fun ToastState.showError(message: String) {
    showToast(message, ToastType.ERROR)
}

fun ToastState.showWarning(message: String) {
    showToast(message, ToastType.WARNING)
}

fun ToastState.showInfo(message: String) {
    showToast(message, ToastType.INFO)
}

