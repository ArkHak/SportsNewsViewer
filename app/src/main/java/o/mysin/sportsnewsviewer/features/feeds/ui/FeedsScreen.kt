package o.mysin.sportsnewsviewer.features.feeds.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import o.mysin.sportsnewsviewer.features.feeds.presentation.FeedsViewModel
import o.mysin.sportsnewsviewer.features.feeds.presentation.models.FeedsAction
import o.mysin.sportsnewsviewer.features.feeds.presentation.models.FeedsEvent
import o.mysin.sportsnewsviewer.features.feeds.presentation.models.StatusScreen
import o.mysin.sportsnewsviewer.ui.common.LoadingIndicator
import org.koin.androidx.compose.koinViewModel

@Composable
internal fun FeedsScreen(
    feedsViewModel: FeedsViewModel = koinViewModel(),
    feedClick: () -> Unit,
) {
    val viewState by feedsViewModel.viewStates().collectAsState()
    val viewAction by feedsViewModel.viewActions().collectAsState(null)

    when (viewState.isStatus) {
        StatusScreen.NULL -> {
            feedsViewModel.obtainEvent(FeedsEvent.LoadingData)
        }

        StatusScreen.SUCCESS -> {
            FeedsView(
                viewState = viewState
            ) { event ->
                feedsViewModel.obtainEvent(event)
            }
        }

        StatusScreen.LOADING -> {
            LoadingIndicator()
        }

        StatusScreen.ERROR -> {}
    }

    when (viewAction) {
        FeedsAction.OpenDetailFeedScreen -> {
            feedClick()
            feedsViewModel.clearAction()
        }

        null -> {}
    }
}