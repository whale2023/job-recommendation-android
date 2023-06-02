package kgb.plum.presentation.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat
import kgb.plum.presentation.ui.theme.color.ColorSet
import kgb.plum.presentation.ui.theme.color.LightYellow
import kgb.plum.presentation.ui.theme.color.MainBlue
import kgb.plum.presentation.ui.theme.color.SkyBlue
import kgb.plum.presentation.ui.theme.color.WhaleColors


private val DarkColorScheme = darkColorScheme(
//    primary = Purple80,
//    secondary = PurpleGrey80,
//    tertiary = Pink80
    primary = MainBlue,
    secondary = SkyBlue,
    tertiary = LightYellow,
    surface = Color.White,
    onSurface = Color.Black
)

private val LocalMaterial = compositionLocalOf { ColorSet.WhaleColor.LightColors.material }
private val LocalColor = compositionLocalOf { ColorSet.WhaleColor.LightColors }

@Composable
fun WhaleTheme(
    whaleColor: ColorSet = ColorSet.WhaleColor,
    typography: Typography = Typography,
    shapes : Shapes = Shapes,
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
        else -> whaleColor.LightColors.material
    }
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.primary.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = darkTheme
        }
    }

    CompositionLocalProvider(LocalMaterial provides colorScheme) {
        MaterialTheme(
            colorScheme = colorScheme,
            typography = typography,
            shapes = shapes,
            content = content
        )
    }
}

val MaterialTheme.colors : WhaleColors
    @Composable
    @ReadOnlyComposable
    get() = LocalColor.current