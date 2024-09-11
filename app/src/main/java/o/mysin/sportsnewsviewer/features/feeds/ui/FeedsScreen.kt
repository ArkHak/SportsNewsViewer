package o.mysin.sportsnewsviewer.features.feeds.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import o.mysin.sportsnewsviewer.features.feeds.presentation.FeedsViewModel
import o.mysin.sportsnewsviewer.features.feeds.presentation.models.FeedsAction

@Composable
internal fun FeedsScreen(
    feedsViewModel: FeedsViewModel = viewModel { FeedsViewModel() },
    feedClick: () -> Unit,
) {
    val viewState by feedsViewModel.viewStates().collectAsState()
    val viewAction by feedsViewModel.viewActions().collectAsState(null)

    FeedsView { event ->
        feedsViewModel.obtainEvent(event)
    }

    when (viewAction) {
        FeedsAction.OpenDetailFeedScreen -> {
            feedClick()
            feedsViewModel.clearAction()
        }

        null -> {}
    }
}