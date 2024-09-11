package o.mysin.sportsnewsviewer.features.favorite.presentation.models

internal sealed class FavoriteEvent {
    data object FeedClicked : FavoriteEvent()
}