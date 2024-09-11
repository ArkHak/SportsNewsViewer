package o.mysin.sportsnewsviewer.features.favorite.presentation

import o.mysin.sportsnewsviewer.base.BaseViewModel
import o.mysin.sportsnewsviewer.features.favorite.presentation.models.FavoriteAction
import o.mysin.sportsnewsviewer.features.favorite.presentation.models.FavoriteEvent
import o.mysin.sportsnewsviewer.features.favorite.presentation.models.FavoriteViewState

internal class FavoriteViewModel :
    BaseViewModel<FavoriteViewState, FavoriteAction, FavoriteEvent>(initialState = FavoriteViewState()) {
    override fun obtainEvent(viewEvent: FavoriteEvent) {
        when (viewEvent) {
            FavoriteEvent.FeedClicked -> feedClicked()
        }
    }

    private fun feedClicked() {
        viewAction = FavoriteAction.OpenDetailFeedScreen
    }

}