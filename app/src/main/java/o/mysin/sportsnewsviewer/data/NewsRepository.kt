package o.mysin.sportsnewsviewer.data

import o.mysin.sportsnewsviewer.data.dto.NewsDetailsDTO
import o.mysin.sportsnewsviewer.data.dto.NewsListResponseDTO
import o.mysin.sportsnewsviewer.data.model.NewsDetailsUI
import o.mysin.sportsnewsviewer.data.utils.Either
import o.mysin.sportsnewsviewer.data.utils.HttpError

internal interface NewsRepository {
    suspend fun getNewsList(): Either<HttpError, NewsListResponseDTO>
    suspend fun getNewsByID(feedId: Int): Either<HttpError, NewsDetailsDTO>
    suspend fun saveFavoriteNews(favoriteNews: NewsDetailsUI)
    suspend fun removeFavoriteNews(newsId: Int)
    suspend fun checkExistsFavoritesNewsInDatabase(newsId: Int): Boolean
}