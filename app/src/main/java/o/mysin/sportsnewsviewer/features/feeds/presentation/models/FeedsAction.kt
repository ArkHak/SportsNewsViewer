package o.mysin.sportsnewsviewer.features.feeds.presentation.models

internal sealed class FeedsAction {
    data class OpenDetailFeedScreen(val feedId: Int) : FeedsAction()
}
