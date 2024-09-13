package o.mysin.sportsnewsviewer.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import o.mysin.sportsnewsviewer.database.entity.FavoriteNewsEntity

@Dao
interface SportsNewsDao {

    @Query("SELECT * FROM favorite_news ORDER BY posted_time DESC")
    suspend fun getAllFavoriteNews(): List<FavoriteNewsEntity>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertFavoriteNews(favoriteNews: FavoriteNewsEntity)

    @Query("DELETE FROM favorite_news WHERE news_id = :newsId")
    suspend fun removeFavoriteNews(newsId: Int)

    @Query("DELETE FROM favorite_news")
    suspend fun deleteAllFavoriteNews()

    @Query("SELECT EXISTS(SELECT * FROM favorite_news WHERE news_id = :newsId)")
    suspend fun checkNewsFavoriteExists(newsId: Int): Boolean

    @Query("SELECT COUNT(*) FROM favorite_news")
    suspend fun getCountNewsFavorite(): Int

}