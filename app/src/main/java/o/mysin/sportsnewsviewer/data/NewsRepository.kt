package o.mysin.sportsnewsviewer.data

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import o.mysin.sportsnewsviewer.data.dto.NewsDetailsDTO
import o.mysin.sportsnewsviewer.data.dto.NewsListResponseDTO
import o.mysin.sportsnewsviewer.data.model.NewsItemUI
import o.mysin.sportsnewsviewer.data.utils.Either
import o.mysin.sportsnewsviewer.data.utils.HttpError
import o.mysin.sportsnewsviewer.database.entity.FavoriteNewsEntity

internal interface NewsRepository {
    suspend fun getNewsList(): Either<HttpError, NewsListResponseDTO>
    suspend fun getNewsPagingList(): Flow<PagingData<NewsItemUI>>
    suspend fun getNewsByID(feedId: Int): Either<HttpError, NewsDetailsDTO>
    suspend fun getFavoriteNews(): List<FavoriteNewsEntity>
    suspend fun saveFavoriteNews(favoriteNews: FavoriteNewsEntity)
    suspend fun removeFavoriteNews(newsId: Int)
    suspend fun checkExistsFavoritesNewsInDatabase(newsId: Int): Boolean
    suspend fun clearFavoriteNewsDatabase()
    suspend fun getCountEntryFavoriteDatabase(): Int
}