package o.mysin.sportsnewsviewer.features.favorite.presentation.models

import o.mysin.sportsnewsviewer.base.BaseStatusScreen
import o.mysin.sportsnewsviewer.data.model.NewsItemUI

internal data class FavoriteViewState(
    val isStatus: BaseStatusScreen = BaseStatusScreen.NULL,
    val favoriteNewsList: List<NewsItemUI> = emptyList(),
)
