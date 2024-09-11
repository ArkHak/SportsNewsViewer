package o.mysin.sportsnewsviewer.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NewsResponse(
    @SerialName("news") val listNews: List<NewsItem>,
    @SerialName("total_count") val totalCount: Int,
)