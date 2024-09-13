package o.mysin.sportsnewsviewer.features.settings.presentation.models

internal sealed class SettingsEvent {
    data object CleanBdButtonPressed : SettingsEvent()
    data object onDismissPressedAlertDialog : SettingsEvent()
    data object onConfirmPressedAlertDialog : SettingsEvent()
}