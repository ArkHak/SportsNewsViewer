package o.mysin.sportsnewsviewer.features.favorite.domain.usecase

import o.mysin.sportsnewsviewer.utils.IsEqualsTwoList.isEqualsTwoList

import o.mysin.sportsnewsviewer.data.NewsRepository
import o.mysin.sportsnewsviewer.data.mappers.dtoToUI.MapNewsDetailsDTOToNewsItemUI
import o.mysin.sportsnewsviewer.data.model.NewsItemUI
import o.mysin.sportsnewsviewer.data.utils.Either
import o.mysin.sportsnewsviewer.data.utils.FormatterDate

internal class GetFavoriteNewsListUseCase(
    private val repository: NewsRepository,
    private val mapNewsDetailsDTOToNewsItemUI: MapNewsDetailsDTOToNewsItemUI,
) {
    suspend operator fun invoke(favoriteNewsList: List<NewsItemUI>): List<NewsItemUI> {

        val favoriteNewsListEntity = repository.getFavoriteNews()

        val favoriteListId: List<Int> = favoriteNewsList.map { it.id }
        val favoriteListIdNow: List<Int> = favoriteNewsListEntity.map { it.newsId }

        val updateListNewsItemUI = if (!isEqualsTwoList(favoriteListId, favoriteListIdNow)) {
            favoriteNewsListEntity.map { newsEntity ->
                when (val eitherResponse = repository.getNewsByID(newsEntity.newsId)) {
                    is Either.Success -> mapNewsDetailsDTOToNewsItemUI.transform(eitherResponse.value)

                    is Either.Fail -> NewsItemUI(
                        id = newsEntity.newsId,
                        title = newsEntity.titleNews,
                        commentCount = "0",
                        socialImage = "",
                        postedTime = FormatterDate.formatDateBDToStringUI(newsEntity.postedTime.toString())
                    )
                }
            }
        } else {
            favoriteNewsList
        }

        return updateListNewsItemUI
    }
}