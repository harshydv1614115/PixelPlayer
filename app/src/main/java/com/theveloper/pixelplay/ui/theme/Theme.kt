package com.theveloper.pixelplay.ui.theme

import android.app.Activity
import android.content.Context
import android.content.ContextWrapper
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat
import com.theveloper.pixelplay.presentation.viewmodel.ColorSchemePair
import androidx.core.graphics.ColorUtils
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.fillMaxSize

val LocalPixelPlayDarkTheme = staticCompositionLocalOf { false }
val LocalShowScrollbar = staticCompositionLocalOf { true }

private tailrec fun Context.findActivity(): Activity? = when (this) {
    is Activity -> this
    is ContextWrapper -> baseContext.findActivity()
    else -> null
}

@Suppress("DEPRECATION")
@Composable
fun PixelPlayStatusBarStyle(
    color: Color,
    useDarkIcons: Boolean = ColorUtils.calculateLuminance(color.toArgb()) > 0.55,
    navigationColor: Color? = null,
    useDarkNavigationIcons: Boolean = navigationColor
        ?.let { ColorUtils.calculateLuminance(it.toArgb()) > 0.55 }
        ?: useDarkIcons
) {
    val view = LocalView.current
    if (view.isInEditMode) return

    val updateNavigationBar = navigationColor != null
    SideEffect {
        val window = view.context.findActivity()?.window ?: return@SideEffect
        window.statusBarColor = android.graphics.Color.TRANSPARENT
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            window.isStatusBarContrastEnforced = false
        }

        WindowCompat.getInsetsController(window, view).run {
            isAppearanceLightStatusBars = useDarkIcons

            if (updateNavigationBar) {
                window.navigationBarColor = android.graphics.Color.TRANSPARENT
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                    window.isNavigationBarContrastEnforced = false
                }
                isAppearanceLightNavigationBars = useDarkNavigationIcons
            }
        }
    }
}

val DarkColorScheme = darkColorScheme(
    primary = PixelPlayPurplePrimary,
    secondary = PixelPlayPink,
    tertiary = PixelPlayOrange,
    background = PixelPlayPurpleDark,
    surface = PixelPlaySurface,
    onPrimary = PixelPlayWhite,
    onSecondary = PixelPlayWhite,
    onTertiary = PixelPlayWhite,
    onBackground = PixelPlayWhite,
    onSurface = PixelPlayLightPurple, // Texto sobre superficies
    error = Color(0xFFFF5252),
    onError = PixelPlayWhite
)

val LightColorScheme = lightColorScheme(
    primary = LightPrimary,
    onPrimary = PixelPlayWhite,
    primaryContainer = LightPrimaryContainer,
    onPrimaryContainer = LightOnPrimaryContainer,
    secondary = PixelPlayPink,
    onSecondary = PixelPlayWhite,
    secondaryContainer = PixelPlayPink.copy(alpha = 0.15f),
    onSecondaryContainer = PixelPlayPink.copy(alpha = 0.85f),
    tertiary = PixelPlayOrange,
    onTertiary = PixelPlayBlack,
    background = LightBackground,
    onBackground = LightOnSurface,
    surface = LightSurface,
    onSurface = LightOnSurface,
    surfaceVariant = LightSurfaceVariant,
    onSurfaceVariant = LightOnSurfaceVariant,
    outline = LightOutline,
    outlineVariant = LightOutline.copy(alpha = 0.6f),
    surfaceTint = LightPrimary,
    error = Color(0xFFD32F2F),
    onError = PixelPlayWhite
)

val LocalPixelPlayThemePreset = staticCompositionLocalOf { "default" }
val LocalPixelPlayLiquidGlass = staticCompositionLocalOf { false }

@Composable
fun PixelPlayTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    colorSchemePairOverride: ColorSchemePair? = null,
    themePresetId: String = "default",
    liquidGlassEffect: Boolean = false,
    content: @Composable () -> Unit
) {
    val context = LocalContext.current
    val preset = com.theveloper.pixelplay.ui.theme.presets.core.PixelPlayerThemePreset.fromId(themePresetId)
    val presetScheme = if (darkTheme) preset.darkColorScheme() else preset.lightColorScheme()

    var baseScheme = when {
        presetScheme != null -> presetScheme
        colorSchemePairOverride != null -> {
            if (darkTheme) colorSchemePairOverride.dark else colorSchemePairOverride.light
        }
        Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            try {
                if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
            } catch (e: Exception) {
                if (darkTheme) DarkColorScheme else LightColorScheme
            }
        }
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    // When Liquid Glass overlay or wallpaper preset is active, ensure background and surfaces are translucent
    val hasWallpaper = preset.wallpaperRes != null || liquidGlassEffect
    val finalColorScheme = if (liquidGlassEffect) {
        baseScheme.copy(
            background = Color.Transparent,
            surface = Color.Transparent,
            surfaceVariant = Color(0x22FFFFFF),
            surfaceContainer = Color(0x28FFFFFF),
            surfaceContainerHigh = Color(0x35FFFFFF),
            surfaceContainerLow = Color(0x15FFFFFF),
            outline = Color(0x50FFFFFF),
            outlineVariant = Color(0x3080EEF5)
        )
    } else if (hasWallpaper) {
        baseScheme.copy(
            background = Color.Transparent,
            surface = Color.Transparent,
        )
    } else {
        baseScheme
    }

    PixelPlayStatusBarStyle(
        color = Color.Transparent,
        navigationColor = Color.Transparent
    )

    CompositionLocalProvider(
        LocalPixelPlayDarkTheme provides darkTheme,
        LocalPixelPlayThemePreset provides themePresetId,
        LocalPixelPlayLiquidGlass provides liquidGlassEffect,
    ) {
        MaterialTheme(
            colorScheme = finalColorScheme,
            typography = Typography,
            shapes = Shapes,
        ) {
            val wallpaperRes = preset.wallpaperRes ?: if (liquidGlassEffect) com.theveloper.pixelplay.R.drawable.bg_crystal_water else null
            if (wallpaperRes != null) {
                androidx.compose.material3.Surface(
                    modifier = androidx.compose.ui.Modifier.fillMaxSize(),
                    color = androidx.compose.ui.graphics.Color.Transparent,
                ) {
                    androidx.compose.foundation.layout.Box(modifier = androidx.compose.ui.Modifier.fillMaxSize()) {
                        androidx.compose.foundation.Image(
                            painter = androidx.compose.ui.res.painterResource(id = wallpaperRes),
                            contentDescription = null,
                            contentScale = androidx.compose.ui.layout.ContentScale.Crop,
                            modifier = androidx.compose.ui.Modifier.fillMaxSize(),
                        )
                        // If liquid glass is on and there is already a wallpaper (e.g. Graduation or Slate Glass), blend the crystal water refraction on top!
                        if (liquidGlassEffect && preset.wallpaperRes != null) {
                            androidx.compose.foundation.Image(
                                painter = androidx.compose.ui.res.painterResource(id = com.theveloper.pixelplay.R.drawable.bg_crystal_water),
                                contentDescription = null,
                                contentScale = androidx.compose.ui.layout.ContentScale.Crop,
                                alpha = 0.65f,
                                modifier = androidx.compose.ui.Modifier.fillMaxSize(),
                            )
                        }
                        content()
                    }
                }
            } else {
                content()
            }
        }
    }
}
