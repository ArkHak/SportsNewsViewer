package o.mysin.sportsnewsviewer.features.feeds.presentation

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import o.mysin.sportsnewsviewer.base.BaseViewModel
import o.mysin.sportsnewsviewer.data.mappers.MapNewsItemDTOToNewsItemUI
import o.mysin.sportsnewsviewer.data.utils.Either
import o.mysin.sportsnewsviewer.features.feeds.presentation.models.FeedsAction
import o.mysin.sportsnewsviewer.features.feeds.presentation.models.FeedsEvent
import o.mysin.sportsnewsviewer.features.feeds.presentation.models.FeedsViewState
import o.mysin.sportsnewsviewer.features.feeds.presentation.models.StatusScreen
import o.mysin.sportsnewsviewer.features.feeds.presentation.usecase.GetNewsUseCase

internal class FeedsViewModel(
    private val getNewsUseCase: GetNewsUseCase,
    private val toNewsItemUI: MapNewsItemDTOToNewsItemUI,
) :
    BaseViewModel<FeedsViewState, FeedsAction, FeedsEvent>(initialState = FeedsViewState()) {

    override fun obtainEvent(viewEvent: FeedsEvent) {
        when (viewEvent) {
            FeedsEvent.FeedClicked -> feedClicked()
            FeedsEvent.LoadingData -> loadingNews()
        }
    }

    //val userUI = toUserUI.transform(userNetwork)

    private fun loadingNews() {
        viewState = viewState.copy(isStatus = StatusScreen.LOADING)
        viewModelScope.launch {
            when (val eitherResponse = getNewsUseCase.invoke()) {
                is Either.Success -> {
                    viewState = viewState.copy(
                        newsList = eitherResponse.value.listNews.map { newsItemDTO ->
                            toNewsItemUI.transform(newsItemDTO)
                        },
                        isStatus = StatusScreen.SUCCESS
                    )
                }

                is Either.Fail -> {
                    viewState = viewState.copy(isStatus = StatusScreen.ERROR)
                }
            }
        }

    }

    private fun feedClicked() {
        viewAction = FeedsAction.OpenDetailFeedScreen
    }

}