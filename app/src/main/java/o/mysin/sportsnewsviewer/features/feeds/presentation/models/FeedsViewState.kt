package o.mysin.sportsnewsviewer.features.feeds.presentation.models

import o.mysin.sportsnewsviewer.base.BaseStatusScreen
import o.mysin.sportsnewsviewer.data.model.NewsItemUI

internal data class FeedsViewState(
    val isStatus: BaseStatusScreen = BaseStatusScreen.NULL,
    val newsList: List<NewsItemUI> = emptyList(),
    val isRefreshingStatus: Boolean = false,
)
