package o.mysin.sportsnewsviewer.features.feeds.presentation

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import o.mysin.sportsnewsviewer.base.BaseViewModel
import o.mysin.sportsnewsviewer.base.BaseStatusScreen
import o.mysin.sportsnewsviewer.data.mappers.dtoToUI.MapNewsItemDTOToNewsItemUI
import o.mysin.sportsnewsviewer.data.utils.Either
import o.mysin.sportsnewsviewer.features.feeds.presentation.models.FeedsAction
import o.mysin.sportsnewsviewer.features.feeds.presentation.models.FeedsEvent
import o.mysin.sportsnewsviewer.features.feeds.presentation.models.FeedsViewState
import o.mysin.sportsnewsviewer.features.feeds.presentation.usecase.GetNewsListUseCase

internal class FeedsViewModel(
    private val getNewsListUseCase: GetNewsListUseCase,
    private val toNewsItemUI: MapNewsItemDTOToNewsItemUI,
) :
    BaseViewModel<FeedsViewState, FeedsAction, FeedsEvent>(initialState = FeedsViewState()) {

    override fun obtainEvent(viewEvent: FeedsEvent) {
        when (viewEvent) {
            FeedsEvent.LoadingData -> loadingNews()
            is FeedsEvent.FeedClicked -> {
                feedClicked(viewEvent.feedId)
            }

            FeedsEvent.FeedsRefresh -> {
                feedsListRefresh()
                loadingNews()
            }
        }
    }

    private fun feedsListRefresh() {
        viewState = viewState.copy(isRefreshingStatus = true)
        loadingNews()
        viewState = viewState.copy(isRefreshingStatus = false)
    }

    private fun loadingNews() {
        viewState = viewState.copy(isStatus = BaseStatusScreen.LOADING)
        viewModelScope.launch {
            when (val eitherResponse = getNewsListUseCase.invoke()) {
                is Either.Success -> {
                    viewState = viewState.copy(
                        newsList = eitherResponse.value.listNews.map { newsItemDTO ->
                            toNewsItemUI.transform(newsItemDTO)
                        },
                        isStatus = BaseStatusScreen.SUCCESS
                    )
                }

                is Either.Fail -> {
                    viewState = viewState.copy(isStatus = BaseStatusScreen.ERROR)
                }
            }
        }
    }

    private fun feedClicked(feedId: Int) {
        viewAction = FeedsAction.OpenDetailFeedScreen(feedId)
    }

}