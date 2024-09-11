package o.mysin.sportsnewsviewer.features.feeds.presentation.models

import o.mysin.sportsnewsviewer.data.NewsItem

data class FeedsViewState(
    val isStatus: StatusScreen = StatusScreen.NULL,
    val newsList: List<NewsItem> = emptyList(),
)

enum class StatusScreen {
    NULL,
    SUCCESS,
    LOADING,
    ERROR
}