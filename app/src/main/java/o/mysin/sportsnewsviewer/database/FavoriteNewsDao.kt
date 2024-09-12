package o.mysin.sportsnewsviewer.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import o.mysin.sportsnewsviewer.database.entity.FavoriteNewsEntity

@Dao
interface FavoriteNewsDao {
    @Query("SELECT * FROM favorite_news")
    suspend fun getAllFavoriteNews(): List<FavoriteNewsEntity>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertFavoriteNews(favoriteNews: FavoriteNewsEntity)

    @Query("DELETE FROM favorite_news WHERE news_id = :newsId")
    suspend fun removeFavoriteNews(newsId: Int)

    @Query("DELETE FROM favorite_news")
    suspend fun deleteAllFavoriteNews()

}