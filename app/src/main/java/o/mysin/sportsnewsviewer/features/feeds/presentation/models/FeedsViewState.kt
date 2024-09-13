package o.mysin.sportsnewsviewer.features.feeds.presentation.models

import androidx.paging.PagingData
import kotlinx.coroutines.flow.MutableStateFlow
import o.mysin.sportsnewsviewer.base.BaseStatusScreen
import o.mysin.sportsnewsviewer.data.model.NewsItemUI

internal data class FeedsViewState(
    val isStatus: BaseStatusScreen = BaseStatusScreen.NULL,
    val newsList: List<NewsItemUI> = emptyList(),
    val newsPagingList: MutableStateFlow<PagingData<NewsItemUI>> = MutableStateFlow(value = PagingData.empty()),
    val isRefreshingStatus: Boolean = false,
)
