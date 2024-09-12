package o.mysin.sportsnewsviewer.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favorite_news")
data class FavoriteNewsEntity(
    @PrimaryKey @ColumnInfo(name = "news_id") val newsId: Int,
    @ColumnInfo(name = "title_news") val titleNews: String,
)
