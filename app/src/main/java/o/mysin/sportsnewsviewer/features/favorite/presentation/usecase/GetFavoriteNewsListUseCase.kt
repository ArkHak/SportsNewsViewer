package o.mysin.sportsnewsviewer.features.favorite.presentation.usecase

import o.mysin.sportsnewsviewer.data.NewsRepository
import o.mysin.sportsnewsviewer.data.model.NewsItemUI
import o.mysin.sportsnewsviewer.data.utils.Either

internal class GetFavoriteNewsListUseCase(
    private val repository: NewsRepository,
) {
    suspend operator fun invoke(): List<NewsItemUI> {
        val favoriteNewsListEntity = repository.getFavoriteNews()
        val listNewsItemUI = favoriteNewsListEntity.map { newsEntity ->
            val eitherResponse = repository.getNewsByID(newsEntity.newsId)

            when (eitherResponse) {
                is Either.Success -> NewsItemUI(
                    id = eitherResponse.value.id,
                    title = eitherResponse.value.title,
                    commentCount = eitherResponse.value.commentCount,
                    socialImage = eitherResponse.value.socialImage,
                    postedTime = eitherResponse.value.postedTime
                )

                is Either.Fail -> NewsItemUI(
                    id = newsEntity.newsId,
                    title = newsEntity.titleNews,
                    commentCount = "0",
                    socialImage = "",
                    postedTime = "00:00 00.00.00"
                )
            }
        }

        return listNewsItemUI
    }
}

//  private fun loadingNews() {
//        viewState = viewState.copy(isStatus = BaseStatusScreen.LOADING)
//        viewModelScope.launch {
//            when (val eitherResponse = getNewsListUseCase.invoke()) {
//                is Either.Success -> {
//                    viewState = viewState.copy(
//                        newsList = eitherResponse.value.listNews.map { newsItemDTO ->
//                            toNewsItemUI.transform(newsItemDTO)
//                        },
//                        isStatus = BaseStatusScreen.SUCCESS
//                    )
//                }
//
//                is Either.Fail -> {
//                    viewState = viewState.copy(isStatus = BaseStatusScreen.ERROR)
//                }
//            }
//        }
//    }

//internal class GetNewsListUseCase(
//    private val repository: NewsRepository,
//) {
//    suspend operator fun invoke(): Either<HttpError, NewsListResponseDTO> = repository.getNewsList()
//}