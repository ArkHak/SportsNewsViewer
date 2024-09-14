package o.mysin.sportsnewsviewer.features.feeds.presentation

import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import o.mysin.sportsnewsviewer.base.BaseViewModel
import o.mysin.sportsnewsviewer.base.BaseStatusScreen
import o.mysin.sportsnewsviewer.data.DataStoreManager
import o.mysin.sportsnewsviewer.data.mappers.dtoToUI.MapNewsItemDTOToNewsItemUI
import o.mysin.sportsnewsviewer.data.utils.Either
import o.mysin.sportsnewsviewer.features.feeds.presentation.models.FeedsAction
import o.mysin.sportsnewsviewer.features.feeds.presentation.models.FeedsEvent
import o.mysin.sportsnewsviewer.features.feeds.presentation.models.FeedsViewState
import o.mysin.sportsnewsviewer.features.feeds.domain.usecase.GetNewsListUseCase

internal class FeedsViewModel(
    private val getNewsListUseCase: GetNewsListUseCase,
    private val toNewsItemUI: MapNewsItemDTOToNewsItemUI,
    private val dataStore: DataStoreManager,
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

    init {
        viewModelScope.launch {
            viewAction = FeedsAction.UpdateAppTheme(dataStore.isDarkTheme.first())
        }
    }

    private fun getPagingNewsList() {
        viewModelScope.launch {
            getNewsListUseCase.invokePaging()
                .distinctUntilChanged()
                .cachedIn(viewModelScope)
                .collect {
                    viewState.newsPagingList.value = it
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
            getPagingNewsList()

            viewState = when (val eitherResponse = getNewsListUseCase.invoke()) {
                is Either.Success -> {
                    viewState.copy(
                        newsList = eitherResponse.value.listNews.map { newsItemDTO ->
                            toNewsItemUI.transform(newsItemDTO)
                        },
                        isStatus = BaseStatusScreen.SUCCESS
                    )
                }

                is Either.Fail -> {
                    viewState.copy(isStatus = BaseStatusScreen.ERROR)
                }
            }
        }
    }

    private fun feedClicked(feedId: Int) {
        viewAction = FeedsAction.OpenDetailFeedScreen(feedId)
    }

}