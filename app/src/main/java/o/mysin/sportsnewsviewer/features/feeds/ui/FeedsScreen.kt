package o.mysin.sportsnewsviewer.features.feeds.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import o.mysin.sportsnewsviewer.base.BaseStatusScreen
import o.mysin.sportsnewsviewer.features.feeds.presentation.FeedsViewModel
import o.mysin.sportsnewsviewer.features.feeds.presentation.models.FeedsAction
import o.mysin.sportsnewsviewer.features.feeds.presentation.models.FeedsEvent
import o.mysin.sportsnewsviewer.ui.common.LoadingIndicator
import org.koin.androidx.compose.koinViewModel

@Composable
internal fun FeedsScreen(
    feedsViewModel: FeedsViewModel = koinViewModel(),
    feedClick: (Int) -> Unit,
) {
    val viewState by feedsViewModel.viewStates().collectAsState()
    val viewAction by feedsViewModel.viewActions().collectAsState(null)

    when (viewState.isStatus) {
        BaseStatusScreen.NULL -> {
            feedsViewModel.obtainEvent(FeedsEvent.LoadingData)
        }

        BaseStatusScreen.SUCCESS -> {
            FeedsView(
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

    when (viewAction) {
        is FeedsAction.OpenDetailFeedScreen -> {
            val id = (viewAction as FeedsAction.OpenDetailFeedScreen).feedId
            feedClick(id)
            feedsViewModel.clearAction()
        }

        null -> {}
    }
}