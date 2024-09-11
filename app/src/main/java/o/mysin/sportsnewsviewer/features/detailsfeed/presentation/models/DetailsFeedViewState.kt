package o.mysin.sportsnewsviewer.features.detailsfeed.presentation.models

import o.mysin.sportsnewsviewer.data.model.NewsDetailsUI
import o.mysin.sportsnewsviewer.features.feeds.presentation.models.StatusScreen

data class DetailsFeedViewState(
    val isStatus: StatusScreen = StatusScreen.NULL,
    val newsDetails: NewsDetailsUI = NewsDetailsUI.emptyNewsDetailsUI(),
)