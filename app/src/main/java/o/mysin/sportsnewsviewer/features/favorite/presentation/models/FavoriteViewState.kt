package o.mysin.sportsnewsviewer.features.favorite.presentation.models

import o.mysin.sportsnewsviewer.data.model.NewsItemUI

internal data class FavoriteViewState(
    val favoriteNewsList: List<NewsItemUI> = emptyList(),
)
