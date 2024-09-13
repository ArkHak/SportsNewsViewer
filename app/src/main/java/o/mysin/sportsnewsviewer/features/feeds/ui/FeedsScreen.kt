package o.mysin.sportsnewsviewer.features.feeds.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.paging.compose.collectAsLazyPagingItems
import o.mysin.sportsnewsviewer.base.BaseStatusScreen
import o.mysin.sportsnewsviewer.features.feeds.presentation.FeedsViewModel
import o.mysin.sportsnewsviewer.features.feeds.presentation.models.FeedsAction
import o.mysin.sportsnewsviewer.features.feeds.presentation.models.FeedsEvent
import o.mysin.sportsnewsviewer.ui.common.LoadingIndicator
import o.mysin.sportsnewsviewer.ui.theme.LocalThemeIsDark
import org.koin.androidx.compose.koinViewModel

@Composable
internal fun FeedsScreen(
    feedsViewModel: FeedsViewModel = koinViewModel(),
    feedClick: (Int) -> Unit,
) {
    val viewState by feedsViewModel.viewStates().collectAsState()
    val viewAction by feedsViewModel.viewActions().collectAsState(null)
    val data = viewState.newsPagingList.collectAsLazyPagingItems()

    when (viewState.isStatus) {
        BaseStatusScreen.NULL -> {
            feedsViewModel.obtainEvent(FeedsEvent.LoadingData)
        }

        BaseStatusScreen.SUCCESS -> {
            FeedsView(
                data = data,
                viewState = viewState
            ) { event ->
                feedsViewModel.obtainEvent(event)
            }
        }

        BaseStatusScreen.LOADING -> {
            LoadingIndicator()
        }

        BaseStatusScreen.ERROR -> {}
    }

    viewAction?.let { viewActionCurrent ->
        when (viewActionCurrent) {
            is FeedsAction.OpenDetailFeedScreen -> {
                val id = viewActionCurrent.feedId
                feedClick(id)
                feedsViewModel.clearAction()
            }

            is FeedsAction.UpdateAppTheme -> {
                LocalThemeIsDark.current.value = viewActionCurrent.isDarkTheme
                feedsViewModel.clearAction()
            }
        }
    }
}