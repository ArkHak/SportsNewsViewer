package o.mysin.sportsnewsviewer.features.favorite.presentation.models


internal sealed class FavoriteAction {
    data class OpenDetailFeedScreen(val feedId: Int) : FavoriteAction()

}
