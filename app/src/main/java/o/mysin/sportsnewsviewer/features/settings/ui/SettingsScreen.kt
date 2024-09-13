package o.mysin.sportsnewsviewer.features.settings.ui

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import o.mysin.sportsnewsviewer.features.settings.presentation.SettingsViewModel
import o.mysin.sportsnewsviewer.features.settings.presentation.models.SettingsAction
import org.koin.androidx.compose.koinViewModel

@Composable
internal fun SettingsScreen(
    settingsViewModel: SettingsViewModel = koinViewModel(),
) {
    val viewState by settingsViewModel.viewStates().collectAsState()
    val viewAction by settingsViewModel.viewActions().collectAsState(null)

    SettingsView(viewState = viewState) { event ->
        settingsViewModel.obtainEvent(event)
    }

    when (viewAction) {
        SettingsAction.openDialogCleanBD -> {
            SettingsAlertDialogView { event ->
                settingsViewModel.obtainEvent(event)
            }
        }

        is SettingsAction.PutToast -> {
            val messageId = (viewAction as SettingsAction.PutToast).messageIdRes
            Toast.makeText(
                LocalContext.current,
                stringResource(messageId),
                Toast.LENGTH_SHORT
            ).show()
            settingsViewModel.clearAction()
        }

        null -> {}
    }


}