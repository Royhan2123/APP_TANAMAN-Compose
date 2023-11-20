package com.example.wildnest.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val DarkColorScheme = darkColorScheme(
    primary = ThemeColor.Dark.primary,
    onPrimary = ThemeColor.Dark.text,
    surface = ThemeColor.Dark.surface,
    background = ThemeColor.Dark.background
)

private val LightColorScheme = lightColorScheme(
    primary = ThemeColor.Light.primary,
    onPrimary = ThemeColor.Light.text,
    surface = ThemeColor.Light.surface,
    background = ThemeColor.Light.background

    /* Other default colors to override
    background = Color(0xFFFFFBFE),
    surface = Color(0xFFFFFBFE),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),
    */
)

@Composable
fun WildNestTheme(
    isDarkTheme:Boolean = isSystemInDarkTheme(),
    content: @Composable ()-> Unit
) {
    MaterialTheme(
        typography = Typography,
        content = content,
        colorScheme = if (isDarkTheme) DarkColorScheme else LightColorScheme
    )
}