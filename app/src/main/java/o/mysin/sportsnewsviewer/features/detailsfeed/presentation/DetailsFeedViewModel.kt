package o.mysin.sportsnewsviewer.features.detailsfeed.presentation

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import o.mysin.sportsnewsviewer.R
import o.mysin.sportsnewsviewer.base.BaseViewModel
import o.mysin.sportsnewsviewer.data.mappers.MapNewsDetailsDTOToNewsDetailsUI
import o.mysin.sportsnewsviewer.data.utils.Either
import o.mysin.sportsnewsviewer.features.detailsfeed.presentation.models.DetailsFeedAction
import o.mysin.sportsnewsviewer.features.detailsfeed.presentation.models.DetailsFeedEvent
import o.mysin.sportsnewsviewer.features.detailsfeed.presentation.models.DetailsFeedViewState
import o.mysin.sportsnewsviewer.features.detailsfeed.presentation.usecase.CheckExistsNewsDatabaseUseCase
import o.mysin.sportsnewsviewer.features.detailsfeed.presentation.usecase.GetNewsByIdUseCase
import o.mysin.sportsnewsviewer.features.detailsfeed.presentation.usecase.ChangeExistsNewsDatabaseUseCase
import o.mysin.sportsnewsviewer.features.feeds.presentation.models.StatusScreen

internal class DetailsFeedViewModel(
    private val getNewsByIdUseCase: GetNewsByIdUseCase,
    private val changeExistsNewsDatabaseUseCase: ChangeExistsNewsDatabaseUseCase,
    private val checkExistsNewsDatabaseUseCase: CheckExistsNewsDatabaseUseCase,
    private val toNewsDetailUI: MapNewsDetailsDTOToNewsDetailsUI,
) :
    BaseViewModel<DetailsFeedViewState, DetailsFeedAction, DetailsFeedEvent>(initialState = DetailsFeedViewState()) {

    override fun obtainEvent(viewEvent: DetailsFeedEvent) {
        when (viewEvent) {
            DetailsFeedEvent.ArrowBackPressed -> arrowBackPressed()
            is DetailsFeedEvent.LoadingData -> {
                loadingFeed(viewEvent.feedId)
            }

            DetailsFeedEvent.FavoriteIconPressed -> {
                changeExistsFavoriteNewsDatabase()
            }
        }
    }

    private fun arrowBackPressed() {
        viewAction = DetailsFeedAction.BackMainScreen
    }

    private fun loadingFeed(feedId: Int) {
        viewState = viewState.copy(isStatus = StatusScreen.LOADING)
        viewModelScope.launch {
            when (val eitherResponse = getNewsByIdUseCase.invoke(feedId)) {
                is Either.Success -> {
                    val exists = checkExistsNewsDatabaseUseCase.invoke(eitherResponse.value.id)
                    viewState = viewState.copy(
                        newsDetails = toNewsDetailUI.transform(eitherResponse.value),
                        isNewsFavorite = exists,
                        isStatus = StatusScreen.SUCCESS
                    )
                }

                is Either.Fail -> {
                    viewState = viewState.copy(isStatus = StatusScreen.ERROR)
                }
            }
        }
    }

    private fun changeExistsFavoriteNewsDatabase() {
        val news = viewState.newsDetails
        viewModelScope.launch {
            changeExistsNewsDatabaseUseCase.invoke(news)
            updateExistFavoriteNewsDatabase()
        }
    }

    private fun updateExistFavoriteNewsDatabase() {
        viewModelScope.launch {
            val newsId = viewState.newsDetails.id
            val checkExists = checkExistsNewsDatabaseUseCase.invoke(newsId)
            viewState = viewState.copy(isNewsFavorite = checkExists)
            viewAction = DetailsFeedAction.PutToast(
                if (checkExists) R.string.toast_add_news_bd else
                    R.string.toast_removed_news_bd
            )
        }
    }

}