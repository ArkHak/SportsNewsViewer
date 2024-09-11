package o.mysin.sportsnewsviewer.features.detailsfeed.presentation

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import o.mysin.sportsnewsviewer.base.BaseViewModel
import o.mysin.sportsnewsviewer.data.mappers.MapNewsDetailsDTOToNewsDetailsUI
import o.mysin.sportsnewsviewer.data.utils.Either
import o.mysin.sportsnewsviewer.features.detailsfeed.presentation.models.DetailsFeedAction
import o.mysin.sportsnewsviewer.features.detailsfeed.presentation.models.DetailsFeedEvent
import o.mysin.sportsnewsviewer.features.detailsfeed.presentation.models.DetailsFeedViewState
import o.mysin.sportsnewsviewer.features.detailsfeed.presentation.usecase.GetNewsByIdUseCase
import o.mysin.sportsnewsviewer.features.feeds.presentation.models.StatusScreen

internal class DetailsFeedViewModel(
    private val getNewsByIdUseCase: GetNewsByIdUseCase,
    private val toNewsDetailUI: MapNewsDetailsDTOToNewsDetailsUI,
) :
    BaseViewModel<DetailsFeedViewState, DetailsFeedAction, DetailsFeedEvent>(initialState = DetailsFeedViewState()) {
    override fun obtainEvent(viewEvent: DetailsFeedEvent) {
        when (viewEvent) {
            DetailsFeedEvent.ArrowBackPressed -> arrowBackPressed()
            is DetailsFeedEvent.LoadingData -> {
                loadingFeed(viewEvent.feedId)
            }
        }
    }

    private fun loadingFeed(feedId: Int) {
        viewState = viewState.copy(isStatus = StatusScreen.LOADING)
        viewModelScope.launch {
            when (val eitherResponse = getNewsByIdUseCase.invoke(feedId)) {
                is Either.Success -> {
                    viewState = viewState.copy(
                        newsDetails = toNewsDetailUI.transform(eitherResponse.value),
                        isStatus = StatusScreen.SUCCESS
                    )
                }

                is Either.Fail -> {
                    viewState = viewState.copy(isStatus = StatusScreen.ERROR)
                }
            }
        }
    }

    private fun arrowBackPressed() {
        viewAction = DetailsFeedAction.BackMainScreen
    }

}