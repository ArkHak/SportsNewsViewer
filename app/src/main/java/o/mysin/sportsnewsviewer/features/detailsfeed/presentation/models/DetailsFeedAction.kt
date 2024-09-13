package o.mysin.sportsnewsviewer.features.detailsfeed.presentation.models


internal sealed class DetailsFeedAction {
    data object BackMainScreen : DetailsFeedAction()
    data class PutToast(val messageIdRes: Int) : DetailsFeedAction()
}
