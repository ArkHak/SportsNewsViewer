package o.mysin.sportsnewsviewer.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier


internal val LocalThemeIsDark = compositionLocalOf { mutableStateOf(false) }

@Composable
internal fun AppTheme(
    content: @Composable() () -> Unit,
) {
    val systemIsDark = isSystemInDarkTheme()
    val isDarkState = remember { mutableStateOf(systemIsDark) }
    CompositionLocalProvider(
        LocalThemeIsDark provides isDarkState,
        LocalSportsColor provides lightPallete,
        content = {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(SportsTheme.colors.primaryBackground)
            ) {
                content.invoke()
            }
        }
    )
}