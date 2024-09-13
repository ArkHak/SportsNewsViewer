package o.mysin.sportsnewsviewer.features.favorite.presentation

import o.mysin.sportsnewsviewer.base.BaseViewModel
import o.mysin.sportsnewsviewer.features.favorite.presentation.models.FavoriteAction
import o.mysin.sportsnewsviewer.features.favorite.presentation.models.FavoriteEvent
import o.mysin.sportsnewsviewer.features.favorite.presentation.models.FavoriteViewState
import o.mysin.sportsnewsviewer.features.feeds.presentation.models.FeedsAction

internal class FavoriteViewModel :
    BaseViewModel<FavoriteViewState, FavoriteAction, FavoriteEvent>(initialState = FavoriteViewState()) {
    override fun obtainEvent(viewEvent: FavoriteEvent) {
        when (viewEvent) {
            is FavoriteEvent.FeedClicked -> {
                feedClicked(viewEvent.feedId)
            }
        }
    }


    private fun feedClicked(feedId: Int) {
        viewAction = FavoriteAction.OpenDetailFeedScreen(feedId)
    }

}