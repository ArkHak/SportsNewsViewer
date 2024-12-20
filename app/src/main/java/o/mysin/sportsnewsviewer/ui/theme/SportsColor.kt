package o.mysin.sportsnewsviewer.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

data class SportsColors(
    val primaryText: Color,
    val primaryBackground: Color,
    val secondaryText: Color,
    val secondaryBackground: Color,
    val cardBackground: Color,
    val accentColor: Color,
    val warningColor: Color,
    val onWarningColor: Color,
    val bottomNavigation: Color
)

object SportsTheme {
    val colors: SportsColors
        @Composable
        get() = LocalSportsColor.current
}

val LocalSportsColor =
    staticCompositionLocalOf<SportsColors> { error("No default implementation for colors") }