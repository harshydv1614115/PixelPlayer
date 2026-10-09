package com.theveloper.pixelplay.ui.theme.presets.slate_glass

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color
import com.theveloper.pixelplay.ui.theme.presets.slate_glass.SlateGlassColors as S

val SlateGlassDarkColorScheme: ColorScheme = darkColorScheme(
    primary = S.ElectricSlate,
    onPrimary = Color(0xFF0F1722),
    primaryContainer = Color(0xFF2C3947),
    onPrimaryContainer = S.PlatinumSilver,

    secondary = S.SlateBlueAccent,
    onSecondary = Color(0xFFFFFFFF),
    secondaryContainer = Color(0xFF232D38),
    onSecondaryContainer = S.TextPrimary,

    tertiary = S.MutedSteel,
    onTertiary = Color(0xFFFFFFFF),
    tertiaryContainer = Color(0xFF333A42),
    onTertiaryContainer = Color(0xFFE2E4E8),

    background = S.DeepSlate,
    onBackground = S.TextPrimary,

    surface = S.DeepSlate,
    onSurface = S.TextPrimary,
    surfaceVariant = S.GlassSurfaceHigh,
    onSurfaceVariant = S.TextSecondary,

    surfaceContainerLowest = Color(0xFF0A0C0E),
    surfaceContainerLow = S.DeepSlate,
    surfaceContainer = S.GlassSurface,
    surfaceContainerHigh = S.GlassSurfaceHigh,
    surfaceContainerHighest = S.GlassSurfaceHighest,

    outline = S.GlassBorderSpecular,
    outlineVariant = Color(0x308BA6C4),

    error = Color(0xFFFF5252),
    onError = Color(0xFF380003),
    errorContainer = Color(0xFF4D0007),
    onErrorContainer = Color(0xFFFFB4AB),
)

val SlateGlassLightColorScheme: ColorScheme = lightColorScheme(
    primary = Color(0xFF3A506B),
    onPrimary = Color(0xFFFFFFFF),
    primaryContainer = Color(0xFFD6E3F2),
    onPrimaryContainer = Color(0xFF0C1D30),

    secondary = Color(0xFF4C5D70),
    onSecondary = Color(0xFFFFFFFF),
    secondaryContainer = Color(0xFFDEE5EE),
    onSecondaryContainer = Color(0xFF1B242E),

    background = Color(0xFFF7F8FA),
    onBackground = Color(0xFF14171A),

    surface = Color(0xFFFFFFFF),
    onSurface = Color(0xFF14171A),
    surfaceVariant = Color(0xFFE5E9EE),
    onSurfaceVariant = Color(0xFF434A54),

    outline = Color(0xFFBCC4CE),
    outlineVariant = Color(0xFFD9DFE6),
)
