package o.mysin.sportsnewsviewer.features.feeds.ui

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.pulltorefresh.PullToRefreshContainer
import androidx.compose.material3.pulltorefresh.rememberPullToRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.items
import o.mysin.sportsnewsviewer.R
import o.mysin.sportsnewsviewer.data.model.NewsItemUI
import o.mysin.sportsnewsviewer.features.feeds.presentation.models.FeedsEvent
import o.mysin.sportsnewsviewer.features.feeds.presentation.models.FeedsViewState
import o.mysin.sportsnewsviewer.features.feeds.ui.views.FeedCard
import o.mysin.sportsnewsviewer.ui.common.LoadingIndicator
import o.mysin.sportsnewsviewer.ui.theme.SportsTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun FeedsView(
    data: LazyPagingItems<NewsItemUI>,
    viewState: FeedsViewState,
    eventHandler: (FeedsEvent) -> Unit,
) {

    val pullToRefreshState = rememberPullToRefreshState()

    if (pullToRefreshState.isRefreshing) {
        LaunchedEffect(true) {
            eventHandler.invoke(FeedsEvent.FeedsRefresh)
        }
    }

    if (!viewState.isRefreshingStatus) {
        pullToRefreshState.endRefresh()
    }

    Box(
        Modifier
            .fillMaxSize()
            .padding(dimensionResource(R.dimen.small_padding_space))
    ) {
        LazyColumn(
            modifier = Modifier
                .nestedScroll(pullToRefreshState.nestedScrollConnection)
        ) {
            items(data) { newsItem ->
                newsItem?.let {
                    FeedCard(it) { feedId ->
                        eventHandler.invoke(FeedsEvent.FeedClicked(feedId))
                    }
                }
            }
            item {
                when (val state = data.loadState.refresh) {
                    is LoadState.Error -> {
                        Log.d(
                            stringResource(R.string.tag_error_loading_feed_item),
                            stringResource(R.string.error_feeds_view_loading_message, state)
                        )
                    }

                    LoadState.Loading -> {
                        LoadingIndicator()
                    }

                    else -> {}
                }

                when (val state = data.loadState.append) {
                    LoadState.Loading -> {
                        LoadingIndicator()
                    }

                    else -> {}
                }
            }
        }

        PullToRefreshContainer(
            state = pullToRefreshState,
            modifier = Modifier.align(
                Alignment.TopCenter,
            ),
            containerColor = SportsTheme.colors.primaryBackground,
            contentColor = SportsTheme.colors.accentColor
        )
    }


}