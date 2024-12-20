package o.mysin.sportsnewsviewer.data.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NewsListResponseDTO(
    @SerialName("news") val listNews: List<NewsItemDTO>,
    @SerialName("total_count") val totalCount: Int,
)