package o.mysin.sportsnewsviewer.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class NewsItem(
    @SerialName("title") val title: String,
    @SerialName("comment_count") val commentCount: String,
    @SerialName("social_image") val socialImage: String,
    @SerialName("posted_time") val postedTime: String,
)