package o.mysin.sportsnewsviewer.features.settings.presentation.models

import o.mysin.sportsnewsviewer.features.detailsfeed.presentation.models.DetailsFeedAction

internal sealed class SettingsAction {
    data object openDialogCleanBD : SettingsAction()
    data class PutToast(val messageIdRes: Int) : SettingsAction()

}
