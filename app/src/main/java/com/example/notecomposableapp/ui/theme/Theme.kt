package com.example.notecomposableapp.ui.theme

import android.app.Activity
import android.content.res.Configuration
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.luminance
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsControllerCompat

// Light color scheme
//val LightColorScheme = lightColorScheme(
//    primary = LightPrimary,
//    secondary = LightSecondary,
//    background = LightBackground,
//    surface = LightSurface,
//    onPrimary = LightOnPrimary,
//    onSecondary = LightOnSecondary,
//    onBackground = LightOnBackground,
//    onSurface = LightOnSurface
//)
// Dark color scheme
//val DarkColorScheme = darkColorScheme(
//    primary = DarkPrimary,
//    secondary = DarkSecondary,
//    background = DarkBackground,
//    surface = DarkSurface,
//    onPrimary = DarkOnPrimary,
//    onSecondary = DarkOnSecondary,
//    onBackground = DarkOnBackground,
//    onSurface = DarkOnSurface
//)
val LightColorScheme = lightColorScheme(
    primary = ColorPrimary,
    secondary = ColorAccent,
    background = ColorPrimaryLight,
    surface = ColorPrimary,
    onPrimary = Color.White, // Assuming white text/icons on primary background
    onSecondary = Color.White, // Assuming white text/icons on secondary background
    onBackground = ColorSecondaryText,
    onSurface =  Color(0xFFFFFF8E1)
)
val DarkColorScheme = lightColorScheme(
    primary = ColorPrimary,
    secondary = ColorAccent,
    background = ColorPrimaryDark,
    surface = ColorPrimary,
    onPrimary = Color.White, // Assuming white text/icons on primary background
    onSecondary = Color.White, // Assuming white text/icons on secondary background
    onBackground = ColorSecondaryText,
    onSurface =  Color(0xFFFFFF8E1)
)

@Composable
fun StatusBarColor(modifier: Modifier = Modifier) {
    val view = LocalView.current
    SideEffect {
        val window = (view.context as Activity).window
        val statusBarColor = ColorPrimary.toArgb()

        // Set the status bar background color
        window.statusBarColor = statusBarColor

        // Ensure the layout fits the system windows
        WindowCompat.setDecorFitsSystemWindows(window, true)

        // Change status bar text/icon color (light or dark)
        val insetsController = WindowInsetsControllerCompat(window, window.decorView)
        if (ColorPrimary.luminance() > 0.5) {
            // Use dark icons/text for light background
            insetsController.isAppearanceLightStatusBars = true
        } else {
            // Use light icons/text for dark background
            insetsController.isAppearanceLightStatusBars = false
        }
    }
}

@Composable
fun NoteComposableAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }
    StatusBarColor()
    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}