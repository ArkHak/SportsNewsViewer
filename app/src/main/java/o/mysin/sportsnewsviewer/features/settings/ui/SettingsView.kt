package o.mysin.sportsnewsviewer.features.settings.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import o.mysin.sportsnewsviewer.R
import o.mysin.sportsnewsviewer.ui.theme.SportsTheme

@Composable
internal fun SettingsView(
//    viewState: SettingsViewState,
//    eventHandler: (NewsEvent) -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 12.dp, vertical = 24.dp)
    ) {
        var checkedTheme by remember { mutableStateOf(true) }

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(R.drawable.ic_theme),
                contentDescription = "Switcher Theme",
                tint = SportsTheme.colors.secondaryText
            )

            Spacer(modifier = Modifier.width(12.dp))

            Text(
                text = "Темная тема",
                fontSize = 18.sp,
                color = SportsTheme.colors.primaryText,
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.SemiBold,
                maxLines = 1,
            )

            Spacer(Modifier.weight(1f))

            Switch(
                checked = checkedTheme,
                onCheckedChange = {
                    checkedTheme = it
                },

                colors = SwitchDefaults.colors(
                    checkedThumbColor = Color.White,
                    uncheckedThumbColor = Color.Black,
                    checkedTrackColor = SportsTheme.colors.accentColor,
                    uncheckedTrackColor = SportsTheme.colors.secondaryBackground
                )
            )

        }

        Spacer(Modifier.height(8.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(R.drawable.ic_clear),
                contentDescription = "Switcher Theme",
                tint = SportsTheme.colors.secondaryText
            )

            Spacer(modifier = Modifier.width(12.dp))

            Text(
                text = "Очистить избранное",
                fontSize = 18.sp,
                color = SportsTheme.colors.primaryText,
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.SemiBold,
                maxLines = 1,
            )

            Spacer(Modifier.weight(1f))


            Button(
                onClick = {},
                colors = ButtonDefaults.buttonColors(
                    containerColor = SportsTheme.colors.warningColor,
                    contentColor = SportsTheme.colors.onWarningColor,
                ),
            ) {

                Text(
                    text = "Clear",
                )
            }
        }

    }
}