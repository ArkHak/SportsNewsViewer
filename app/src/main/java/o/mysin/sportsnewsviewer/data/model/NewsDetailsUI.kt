package o.mysin.sportsnewsviewer.data.model

import kotlinx.serialization.Serializable

@Serializable
data class NewsDetailsUI(
    val id: Int,
    val title: String,
    val commentCount: String,
    val socialImage: String,
    val postedTime: String,
    val description: String,
) {
    companion object {
        fun emptyNewsDetailsUI(): NewsDetailsUI {
            return NewsDetailsUI(
                id = -1,
                title = "",
                commentCount = "-1",
                socialImage = "",
                postedTime = "-1",
                description = "",
            )
        }
    }
}
