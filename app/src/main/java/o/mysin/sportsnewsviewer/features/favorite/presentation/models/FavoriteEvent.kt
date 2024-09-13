package o.mysin.sportsnewsviewer.features.favorite.presentation.models


internal sealed class FavoriteEvent {
    data class FeedClicked(val feedId: Int) : FavoriteEvent()
    data object LoadingData : FavoriteEvent()
    data object UpdateData : FavoriteEvent()

}