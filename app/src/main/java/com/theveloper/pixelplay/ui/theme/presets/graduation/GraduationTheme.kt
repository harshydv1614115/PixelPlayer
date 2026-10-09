package com.theveloper.pixelplay.ui.theme.presets.graduation

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color
import com.theveloper.pixelplay.ui.theme.presets.graduation.GraduationColors as G

val GraduationDarkColorScheme: ColorScheme = darkColorScheme(
    primary = G.SunsetCoral,
    onPrimary = G.OnSunsetCoral,
    primaryContainer = Color(0xFF4A1A28),
    onPrimaryContainer = G.SunsetCoralLight,

    secondary = G.SunlightGold,
    onSecondary = G.OnSunlightGold,
    secondaryContainer = Color(0xFF38240D),
    onSecondaryContainer = Color(0xFFFFECC4),

    tertiary = Color(0xFFD4BBE8),
    onTertiary = Color(0xFF281440),
    tertiaryContainer = Color(0xFF3A1E5C),
    onTertiaryContainer = Color(0xFFF3E8FC),

    background = G.DeepPlum,
    onBackground = G.TextPrimary,

    surface = G.DeepPlum,
    onSurface = G.TextPrimary,
    surfaceVariant = G.GlassSurfaceHigh,
    onSurfaceVariant = G.TextSecondary,

    surfaceContainerLowest = G.DarkAmethyst,
    surfaceContainerLow = G.DeepPlum,
    surfaceContainer = G.GlassSurface,
    surfaceContainerHigh = G.GlassSurfaceHigh,
    surfaceContainerHighest = G.GlassSurfaceHighest,

    outline = G.GlassBorderSpecular,
    outlineVariant = G.OutlineSubtle,

    error = Color(0xFFFF5252),
    onError = Color(0xFF380003),
    errorContainer = Color(0xFF4D0007),
    onErrorContainer = Color(0xFFFFB4AB),
)

val GraduationLightColorScheme: ColorScheme = lightColorScheme(
    primary = Color(0xFFD83A64),
    onPrimary = Color(0xFFFFFFFF),
    primaryContainer = Color(0xFFFFD9E2),
    onPrimaryContainer = Color(0xFF3B0015),

    secondary = Color(0xFF825500),
    onSecondary = Color(0xFFFFFFFF),
    secondaryContainer = Color(0xFFFFDDB3),
    onSecondaryContainer = Color(0xFF2A1800),

    background = Color(0xFFFCF7FD),
    onBackground = Color(0xFF1E1624),

    surface = Color(0xFFFFFFFF),
    onSurface = Color(0xFF1E1624),
    surfaceVariant = Color(0xFFF0E5F4),
    onSurfaceVariant = Color(0xFF504355),

    outline = Color(0xFFD2C1D6),
    outlineVariant = Color(0xFFE8DEEC),
)
