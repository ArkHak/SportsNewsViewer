package o.mysin.sportsnewsviewer.features.settings.presentation

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import o.mysin.sportsnewsviewer.base.BaseViewModel
import o.mysin.sportsnewsviewer.features.settings.presentation.models.SettingsAction
import o.mysin.sportsnewsviewer.features.settings.presentation.models.SettingsEvent
import o.mysin.sportsnewsviewer.features.settings.presentation.models.SettingsViewState
import o.mysin.sportsnewsviewer.features.settings.presentation.usecase.ClearFavoriteNewsDatabaseUseCase

internal class SettingsViewModel(
    private val clearFavoriteNewsDatabaseUseCase: ClearFavoriteNewsDatabaseUseCase,
) : BaseViewModel<SettingsViewState, SettingsAction, SettingsEvent>(initialState = SettingsViewState()) {

    override fun obtainEvent(viewEvent: SettingsEvent) {
        when (viewEvent) {
            SettingsEvent.CleanBdButtonPressed -> openDialogCleanBD()
            SettingsEvent.onConfirmPressedAlertDialog -> {
                cleanFavoriteBD()
            }

            SettingsEvent.onDismissPressedAlertDialog -> clearAction()
        }
    }

    private fun cleanFavoriteBD() {
        viewModelScope.launch {
            clearFavoriteNewsDatabaseUseCase.invoke()
            clearAction()
        }
    }


    private fun openDialogCleanBD() {
        viewAction = SettingsAction.openDialogCleanBD
    }

}