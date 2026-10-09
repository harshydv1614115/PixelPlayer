package com.theveloper.pixelplay.ui.theme.presets.core

import androidx.compose.material3.ColorScheme
import androidx.compose.ui.graphics.Color
import com.theveloper.pixelplay.ui.theme.presets.amoled_black.AmoledBlackDarkColorScheme
import com.theveloper.pixelplay.ui.theme.presets.amoled_black.AmoledBlackLightColorScheme
import com.theveloper.pixelplay.ui.theme.presets.graduation.GraduationDarkColorScheme
import com.theveloper.pixelplay.ui.theme.presets.graduation.GraduationLightColorScheme
import com.theveloper.pixelplay.ui.theme.presets.slate_glass.SlateGlassDarkColorScheme
import com.theveloper.pixelplay.ui.theme.presets.slate_glass.SlateGlassLightColorScheme

enum class PixelPlayerThemePreset(
    val id: String,
    val title: String,
    val subtitle: String,
    val previewPrimary: Color,
    val previewBackground: Color,
    val previewAccent: Color,
    val wallpaperRes: Int? = null,
) {
    DEFAULT(
        id = "default",
        title = "Dynamic Material You",
        subtitle = "Matches your Android wallpaper & system colors",
        previewPrimary = Color(0xFF6750A4),
        previewBackground = Color(0xFF141218),
        previewAccent = Color(0xFFD0BCFF),
    ),
    GRADUATION(
        id = "graduation",
        title = "Graduation ( YE )",
        subtitle = "Murakami sunset • Celestial frosted glass",
        previewPrimary = Color(0xFFFF6584),
        previewBackground = Color(0xFF1B0E2A),
        previewAccent = Color(0xFFFFD580),
        wallpaperRes = com.theveloper.pixelplay.R.drawable.bg_graduation,
    ),
    SLATE_GLASS(
        id = "slate_glass",
        title = "Slate Frosted Glass",
        subtitle = "Titanium slate • Refined liquid glass",
        previewPrimary = Color(0xFF8BA6C4),
        previewBackground = Color(0xFF0F1115),
        previewAccent = Color(0xFF6B8299),
        wallpaperRes = com.theveloper.pixelplay.R.drawable.bg_slate_glass,
    ),
    AMOLED_BLACK(
        id = "amoled_black",
        title = "True AMOLED Black",
        subtitle = "Pure #000000 pitch black • Infinite contrast",
        previewPrimary = Color(0xFFFFFFFF),
        previewBackground = Color(0xFF000000),
        previewAccent = Color(0xFF1E1E1E),
    );

    fun darkColorScheme(): ColorScheme? = when (this) {
        DEFAULT -> null
        GRADUATION -> GraduationDarkColorScheme
        SLATE_GLASS -> SlateGlassDarkColorScheme
        AMOLED_BLACK -> AmoledBlackDarkColorScheme
    }

    fun lightColorScheme(): ColorScheme? = when (this) {
        DEFAULT -> null
        GRADUATION -> GraduationLightColorScheme
        SLATE_GLASS -> SlateGlassLightColorScheme
        AMOLED_BLACK -> AmoledBlackLightColorScheme
    }

    companion object {
        fun fromId(id: String?): PixelPlayerThemePreset =
            entries.firstOrNull { it.id == id } ?: DEFAULT
    }
}
