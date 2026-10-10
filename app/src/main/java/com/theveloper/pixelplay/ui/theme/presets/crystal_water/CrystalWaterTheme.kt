package com.theveloper.pixelplay.ui.theme.presets.crystal_water

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color
import com.theveloper.pixelplay.ui.theme.presets.crystal_water.CrystalWaterColors as W

val CrystalWaterDarkColorScheme: ColorScheme = darkColorScheme(
    primary = W.CrystalCyanAccent,
    onPrimary = Color(0xFF002022),
    primaryContainer = Color(0x305CE1E6),
    onPrimaryContainer = W.PureAquaHighlight,

    secondary = W.PureAquaHighlight,
    onSecondary = Color(0xFF002022),
    secondaryContainer = Color(0x2080EEF5),
    onSecondaryContainer = W.TextPrimary,

    tertiary = W.CausticGlow,
    onTertiary = Color(0xFF002022),
    tertiaryContainer = Color(0x259FF8FF),
    onTertiaryContainer = Color(0xFFFFFFFF),

    background = W.DeepWaterVoid,
    onBackground = W.TextPrimary,

    surface = Color.Transparent,
    onSurface = W.TextPrimary,
    surfaceVariant = W.GlassSurfaceCard,
    onSurfaceVariant = W.TextSecondary,

    surfaceContainerLowest = Color(0x0AFFFFFF),
    surfaceContainerLow = W.GlassSurfaceUltraClear,
    surfaceContainer = W.GlassSurfaceCard,
    surfaceContainerHigh = W.GlassSurfaceElevated,
    surfaceContainerHighest = Color(0x45FFFFFF),

    outline = W.GlassBorderLuminous,
    outlineVariant = W.GlassBorderSubtle,

    error = Color(0xFFFF5449),
    onError = Color(0xFF690005),
    errorContainer = Color(0x35FF5449),
    onErrorContainer = Color(0xFFFFDAD6),
)

val CrystalWaterLightColorScheme: ColorScheme = lightColorScheme(
    primary = Color(0xFF006874),
    onPrimary = Color(0xFFFFFFFF),
    primaryContainer = Color(0x25006874),
    onPrimaryContainer = Color(0xFF001F24),

    secondary = Color(0xFF4A6267),
    onSecondary = Color(0xFFFFFFFF),
    secondaryContainer = Color(0x1F4A6267),
    onSecondaryContainer = Color(0xFF051F23),

    background = Color(0xFFFBFDFD),
    onBackground = Color(0xFF191C1D),

    surface = Color.Transparent,
    onSurface = Color(0xFF191C1D),
    surfaceVariant = Color(0x18000000),
    onSurfaceVariant = Color(0xFF3F484A),

    outline = Color(0x40006874),
    outlineVariant = Color(0x20006874),
)
