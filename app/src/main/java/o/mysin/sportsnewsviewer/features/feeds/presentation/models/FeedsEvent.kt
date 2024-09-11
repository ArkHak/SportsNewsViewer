package o.mysin.sportsnewsviewer.features.feeds.presentation.models

internal sealed class FeedsEvent {
    data class FeedClicked(val feedId: Int) : FeedsEvent()
    data object LoadingData : FeedsEvent()
}