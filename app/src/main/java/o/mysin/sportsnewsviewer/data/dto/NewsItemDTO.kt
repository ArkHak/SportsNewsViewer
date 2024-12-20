package o.mysin.sportsnewsviewer.data.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class NewsItemDTO(
    @SerialName("id") val id: Int,
    @SerialName("title") val title: String,
    @SerialName("comment_count") val commentCount: String,
    @SerialName("social_image") val socialImage: String,
    @SerialName("posted_time") val postedTime: String,
)