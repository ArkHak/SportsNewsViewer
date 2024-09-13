package o.mysin.sportsnewsviewer.features.settings.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import o.mysin.sportsnewsviewer.features.settings.presentation.SettingsViewModel
import o.mysin.sportsnewsviewer.features.settings.presentation.models.SettingsAction
import org.koin.androidx.compose.koinViewModel

@Composable
internal fun SettingsScreen(
    settingsViewModel: SettingsViewModel = koinViewModel(),
) {
    val viewState by settingsViewModel.viewStates().collectAsState()
    val viewAction by settingsViewModel.viewActions().collectAsState(null)


    SettingsView { event ->
        settingsViewModel.obtainEvent(event)
    }

    when (viewAction) {
        SettingsAction.openDialogCleanBD -> {
            SettingsAlertDialogView { event ->
                settingsViewModel.obtainEvent(event)
            }
        }

        null -> {}
    }


}