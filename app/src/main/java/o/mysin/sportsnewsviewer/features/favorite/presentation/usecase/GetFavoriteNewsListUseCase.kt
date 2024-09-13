package o.mysin.sportsnewsviewer.features.favorite.presentation.usecase

import o.mysin.sportsnewsviewer.utils.IsEqualsTwoList.isEqualsTwoList

import o.mysin.sportsnewsviewer.data.NewsRepository
import o.mysin.sportsnewsviewer.data.model.NewsItemUI
import o.mysin.sportsnewsviewer.data.utils.Either

internal class GetFavoriteNewsListUseCase(
    private val repository: NewsRepository,
) {
    suspend operator fun invoke(favoriteNewsList: List<NewsItemUI>): List<NewsItemUI> {

        val favoriteNewsListEntity = repository.getFavoriteNews()

        val favoriteListId: List<Int> = favoriteNewsList.map { it.id }
        val favoriteListIdNow: List<Int> = favoriteNewsListEntity.map { it.newsId }

        val updateListNewsItemUI = if (!isEqualsTwoList(favoriteListId, favoriteListIdNow)) {
            favoriteNewsListEntity.map { newsEntity ->
                when (val eitherResponse = repository.getNewsByID(newsEntity.newsId)) {
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
        } else {
            favoriteNewsList
        }

        return updateListNewsItemUI
    }
}