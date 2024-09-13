package o.mysin.sportsnewsviewer.features.favorite.presentation

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import o.mysin.sportsnewsviewer.base.BaseStatusScreen
import o.mysin.sportsnewsviewer.base.BaseViewModel
import o.mysin.sportsnewsviewer.features.favorite.presentation.models.FavoriteAction
import o.mysin.sportsnewsviewer.features.favorite.presentation.models.FavoriteEvent
import o.mysin.sportsnewsviewer.features.favorite.presentation.models.FavoriteViewState
import o.mysin.sportsnewsviewer.features.favorite.presentation.usecase.GetFavoriteNewsListUseCase

internal class FavoriteViewModel(
    private val getFavoriteNewsListUseCase: GetFavoriteNewsListUseCase,
) :
    BaseViewModel<FavoriteViewState, FavoriteAction, FavoriteEvent>(initialState = FavoriteViewState()) {
    override fun obtainEvent(viewEvent: FavoriteEvent) {
        when (viewEvent) {

            FavoriteEvent.LoadingData -> loadingFavoriteNews()

            is FavoriteEvent.FeedClicked -> {
                feedClicked(viewEvent.feedId)
            }

            FavoriteEvent.UpdateData -> {
                viewState = viewState.copy(isStatus = BaseStatusScreen.NULL)
            }
        }
    }

    private fun loadingFavoriteNews() {
        viewState = viewState.copy(isStatus = BaseStatusScreen.LOADING)
        viewModelScope.launch {
            val list = getFavoriteNewsListUseCase.invoke(viewState.favoriteNewsList)
            viewState = viewState.copy(
                favoriteNewsList = list,
                isStatus = BaseStatusScreen.SUCCESS
            )
        }
    }


    private fun feedClicked(feedId: Int) {
        viewAction = FavoriteAction.OpenDetailFeedScreen(feedId)
    }

}