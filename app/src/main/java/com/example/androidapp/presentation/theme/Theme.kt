package com.example.androidapp.presentation.theme

import android.app.Activity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val DarkColorPalette = darkColorScheme(
    primary = Primary10,
    primaryContainer = Primary60,
    secondary = Secondary40
)

private val LightColorPalette = lightColorScheme(
    primary = Primary10,
    primaryContainer = Primary60,
    secondary = Secondary40
)

@Composable
fun AppTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = StatusBarColor.toArgb()
            window.navigationBarColor = Color.White.toArgb()

            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = darkTheme
            WindowCompat.getInsetsController(window, view).isAppearanceLightNavigationBars = darkTheme
        }
    }
    MaterialTheme(
        colorScheme = if (darkTheme) DarkColorPalette else LightColorPalette,
        shapes = Shapes,
        content = content
    )
}