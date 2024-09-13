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
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import o.mysin.sportsnewsviewer.R
import o.mysin.sportsnewsviewer.features.settings.presentation.models.SettingsEvent
import o.mysin.sportsnewsviewer.ui.theme.SportsTheme

@Composable
internal fun SettingsView(
//    viewState: SettingsViewState,
    eventHandler: (SettingsEvent) -> Unit,
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                horizontal = dimensionResource(R.dimen.normal_large_padding_space),
                vertical = dimensionResource(R.dimen.extra_large_padding_space)
            )
    ) {
        var checkedTheme by remember { mutableStateOf(true) }

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(R.drawable.ic_theme),
                contentDescription = stringResource(R.string.cont_des_switcher_theme),
                tint = SportsTheme.colors.secondaryText
            )

            Spacer(modifier = Modifier.width(dimensionResource(R.dimen.small_large_size_horizontal_spacer)))

            Text(
                text = stringResource(R.string.dark_theme_button),
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

        Spacer(Modifier.height(dimensionResource(R.dimen.small_size_horizontal_spacer)))

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(R.drawable.ic_clear),
                contentDescription = stringResource(R.string.cont_des_clean_favorite_data),
                tint = SportsTheme.colors.secondaryText
            )

            Spacer(modifier = Modifier.width(dimensionResource(R.dimen.small_large_size_horizontal_spacer)))

            Text(
                text = stringResource(R.string.clear_favorite_data),
                fontSize = 18.sp,
                color = SportsTheme.colors.primaryText,
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.SemiBold,
                maxLines = 1,
            )

            Spacer(Modifier.weight(1f))


            Button(
                onClick = { eventHandler.invoke(SettingsEvent.CleanBdButtonPressed) },
                colors = ButtonDefaults.buttonColors(
                    containerColor = SportsTheme.colors.warningColor,
                    contentColor = SportsTheme.colors.onWarningColor,
                ),
            ) {

                Text(
                    text = stringResource(R.string.button_name_clear),
                )
            }
        }

    }
}