package o.mysin.sportsnewsviewer.data

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import o.mysin.sportsnewsviewer.data.dto.NewsDetailsDTO
import o.mysin.sportsnewsviewer.data.dto.NewsListResponseDTO
import o.mysin.sportsnewsviewer.data.mappers.dtoToUI.MapNewsItemDTOToNewsItemUI
import o.mysin.sportsnewsviewer.data.model.NewsItemUI
import o.mysin.sportsnewsviewer.data.remote.ApiService
import o.mysin.sportsnewsviewer.data.remote.PostPagingDataSource
import o.mysin.sportsnewsviewer.data.utils.Either
import o.mysin.sportsnewsviewer.data.utils.HttpError
import o.mysin.sportsnewsviewer.database.SportsNewsDao
import o.mysin.sportsnewsviewer.database.entity.FavoriteNewsEntity


internal class NewsRepositoryImpl(
    private val apiService: ApiService,
    private val sportsNewsDao: SportsNewsDao,
    private val mapNewsItemDTOToNewsItemUI: MapNewsItemDTOToNewsItemUI,
) : NewsRepository {

    override suspend fun getNewsList(): Either<HttpError, NewsListResponseDTO> =
        apiService.getNewsListNetwork()

    override suspend fun getNewsPagingList(): Flow<PagingData<NewsItemUI>> =
        Pager(
            config = PagingConfig(pageSize = 10),
            pagingSourceFactory = {
                PostPagingDataSource(
                    apiService = apiService,
                    mapNewsItemDTOToNewsItemUI = mapNewsItemDTOToNewsItemUI
                )
            }
        ).flow


    override suspend fun getNewsByID(feedId: Int): Either<HttpError, NewsDetailsDTO> =
        apiService.getNewsByIDNetwork(feedId)

    override suspend fun getFavoriteNews(): List<FavoriteNewsEntity> =
        sportsNewsDao.getAllFavoriteNews()


    override suspend fun saveFavoriteNews(favoriteNews: FavoriteNewsEntity) {
        sportsNewsDao.insertFavoriteNews(favoriteNews)
    }

    override suspend fun removeFavoriteNews(newsId: Int) {
        sportsNewsDao.removeFavoriteNews(newsId)
    }

    override suspend fun checkExistsFavoritesNewsInDatabase(newsId: Int): Boolean =
        sportsNewsDao.checkNewsFavoriteExists(newsId = newsId)

    override suspend fun clearFavoriteNewsDatabase() {
        sportsNewsDao.deleteAllFavoriteNews()
    }

    override suspend fun getCountEntryFavoriteDatabase(): Int {
        return sportsNewsDao.getCountNewsFavorite()
    }

}