package o.mysin.sportsnewsviewer.features.settings.presentation.models


internal sealed class SettingsEvent {
    data object CleanBdButtonPressed : SettingsEvent()
    data object OnDismissPressedAlertDialog : SettingsEvent()
    data object OnConfirmPressedAlertDialog : SettingsEvent()
    data class SaveIsDarkTheme(val isDarkTheme: Boolean) : SettingsEvent()
}