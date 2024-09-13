package o.mysin.sportsnewsviewer.features.settings.ui

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.sp
import o.mysin.sportsnewsviewer.R
import o.mysin.sportsnewsviewer.features.settings.presentation.models.SettingsEvent
import o.mysin.sportsnewsviewer.ui.theme.SportsTheme

@Composable
internal fun SettingsAlertDialogView(
    eventHandler: (SettingsEvent) -> Unit,
) {
    AlertDialog(
        onDismissRequest = { eventHandler.invoke(SettingsEvent.OnDismissPressedAlertDialog) },
        title = { Text(text = stringResource(R.string.title_alert_dialog)) },
        text = { Text(stringResource(R.string.settings_description_alert_dialog)) },
        confirmButton = {
            Button(
                onClick = { eventHandler.invoke(SettingsEvent.OnConfirmPressedAlertDialog) },
                colors = ButtonDefaults.buttonColors(
                    containerColor = SportsTheme.colors.accentColor,
                    contentColor = SportsTheme.colors.onWarningColor,
                ),
            ) {
                Text(stringResource(R.string.alert_dialog_confirm), fontSize = 14.sp)
            }
        },
        dismissButton = {
            Button(
                onClick = { eventHandler.invoke(SettingsEvent.OnDismissPressedAlertDialog) },
                colors = ButtonDefaults.buttonColors(
                    containerColor = SportsTheme.colors.warningColor,
                    contentColor = SportsTheme.colors.onWarningColor,
                ),
            ) {
                Text(stringResource(R.string.alert_dialog_dismiss), fontSize = 14.sp)
            }
        },
    )
}