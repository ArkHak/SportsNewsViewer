package o.mysin.sportsnewsviewer.features.feeds.presentation.models

internal sealed class FeedsEvent {
    data object FeedClicked : FeedsEvent()
}