package o.mysin.sportsnewsviewer.features.feeds.presentation.models

import o.mysin.sportsnewsviewer.data.model.NewsItemUI

internal data class FeedsViewState(
    val isStatus: StatusScreen = StatusScreen.NULL,
    val newsList: List<NewsItemUI> = emptyList(),
    val isRefreshingStatus: Boolean = false,
)

enum class StatusScreen {
    NULL,
    SUCCESS,
    LOADING,
    ERROR
}