package com.example.notecomposableapp.ui.theme

import android.content.res.Configuration
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

// Light color scheme
val LightColorScheme = lightColorScheme(
    primary = LightPrimary,
    secondary = LightSecondary,
    background = LightBackground,
    surface = LightSurface,
    onPrimary = LightOnPrimary,
    onSecondary = LightOnSecondary,
    onBackground = LightOnBackground,
    onSurface = LightOnSurface
)

// Dark color scheme
val DarkColorScheme = darkColorScheme(
    primary = DarkPrimary,
    secondary = DarkSecondary,
    background = DarkBackground,
    surface = DarkSurface,
    onPrimary = DarkOnPrimary,
    onSecondary = DarkOnSecondary,
    onBackground = DarkOnBackground,
    onSurface = DarkOnSurface
)


@Composable
fun cardBGColor(): Color {
    // Get current context
    val context = LocalContext.current

    // Get current configuration from the context
    val currentMode = context.resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK

    // Check if the current mode is night (dark) or not (light)
    return if (currentMode == Configuration.UI_MODE_NIGHT_YES) {
        // Dark mode
       DarkCardBGColor
    } else {
        // Light mode
       LightCardBGColor
    }
}
@Composable
fun searchBoxBGColor(): Color {
    // Get current context
    val context = LocalContext.current

    // Get current configuration from the context
    val currentMode = context.resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK

    // Check if the current mode is night (dark) or not (light)
    return if (currentMode == Configuration.UI_MODE_NIGHT_YES) {
        // Dark mode
        DarkSearchBoxBGColor
    } else {
        // Light mode
        LightSearchBoxBGColor
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

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}