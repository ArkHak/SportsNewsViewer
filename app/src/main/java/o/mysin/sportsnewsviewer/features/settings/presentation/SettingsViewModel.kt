package o.mysin.sportsnewsviewer.features.settings.presentation

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import o.mysin.sportsnewsviewer.R
import o.mysin.sportsnewsviewer.base.BaseViewModel
import o.mysin.sportsnewsviewer.data.DataStoreManager
import o.mysin.sportsnewsviewer.features.settings.presentation.models.SettingsAction
import o.mysin.sportsnewsviewer.features.settings.presentation.models.SettingsEvent
import o.mysin.sportsnewsviewer.features.settings.presentation.models.SettingsViewState
import o.mysin.sportsnewsviewer.features.settings.presentation.usecase.CheckEmptyFavoriteNewsDatabaseUseCase
import o.mysin.sportsnewsviewer.features.settings.presentation.usecase.ClearFavoriteNewsDatabaseUseCase

internal class SettingsViewModel(
    private val clearFavoriteNewsDatabaseUseCase: ClearFavoriteNewsDatabaseUseCase,
    private val checkEmptyFavoriteNewsDatabaseUseCase: CheckEmptyFavoriteNewsDatabaseUseCase,
    private val dataStore: DataStoreManager,
) : BaseViewModel<SettingsViewState, SettingsAction, SettingsEvent>(
    initialState = SettingsViewState(isDarkTheme = false)
) {

    init {
        initColorTheme()
    }

    private fun initColorTheme() {
        viewModelScope.launch {
            val isDarkTheme = dataStore.isDarkTheme.first()
            viewState = viewState.copy(isDarkTheme = isDarkTheme)
        }
    }

    override fun obtainEvent(viewEvent: SettingsEvent) {
        when (viewEvent) {
            SettingsEvent.CleanBdButtonPressed -> openDialogCleanBD()
            SettingsEvent.OnConfirmPressedAlertDialog -> {
                cleanFavoriteBD()
            }

            SettingsEvent.OnDismissPressedAlertDialog -> clearAction()
            is SettingsEvent.SaveIsDarkTheme -> {
                saveIsDarkTheme(viewEvent.isDarkTheme)
            }
        }
    }

    private fun saveIsDarkTheme(isDarkTheme: Boolean) {
        viewModelScope.launch {
            viewState = viewState.copy(isDarkTheme = isDarkTheme)
            dataStore.setIsDarkTheme(isDarkTheme)
        }
    }

    private fun cleanFavoriteBD() {
        viewModelScope.launch {
            clearFavoriteNewsDatabaseUseCase.invoke()

            val checkEmptyDatabase = checkEmptyFavoriteNewsDatabaseUseCase.invoke()
            viewAction = SettingsAction.PutToast(
                if (checkEmptyDatabase) R.string.toast_clean_bd else
                    R.string.toast_error_clean_bd
            )
        }
    }


    private fun openDialogCleanBD() {
        viewAction = SettingsAction.openDialogCleanBD
    }

}