package o.mysin.sportsnewsviewer.features.detailsfeed.presentation.models

internal sealed class DetailsFeedEvent {
    data object ArrowBackPressed : DetailsFeedEvent()
}