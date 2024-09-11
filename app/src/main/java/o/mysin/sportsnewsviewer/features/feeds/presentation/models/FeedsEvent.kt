package o.mysin.sportsnewsviewer.features.feeds.presentation.models

internal sealed class FeedsEvent {
    data object FeedClicked : FeedsEvent()
    data object LoadingData : FeedsEvent()
}