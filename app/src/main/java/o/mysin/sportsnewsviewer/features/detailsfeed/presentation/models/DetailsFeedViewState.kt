package o.mysin.sportsnewsviewer.features.detailsfeed.presentation.models

import o.mysin.sportsnewsviewer.base.BaseStatusScreen
import o.mysin.sportsnewsviewer.data.model.NewsDetailsUI

data class DetailsFeedViewState(
    val isStatus: BaseStatusScreen = BaseStatusScreen.NULL,
    val newsDetails: NewsDetailsUI = NewsDetailsUI.emptyNewsDetailsUI(),
    val isNewsFavorite: Boolean = false,
)