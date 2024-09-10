package o.mysin.sportsnewsviewer.features.feeds.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import o.mysin.sportsnewsviewer.features.feeds.presentation.FeedsViewModel
import o.mysin.sportsnewsviewer.features.feeds.presentation.models.FeedsAction
import o.mysin.sportsnewsviewer.features.navigations.AppScreens
import o.mysin.sportsnewsviewer.features.navigations.LocalNavHost

@Composable
internal fun FeedsScreen(
    feedsViewModel: FeedsViewModel = viewModel { FeedsViewModel() },
) {
    val outerNavController = LocalNavHost.current
    val viewState by feedsViewModel.viewStates().collectAsState()
    val viewAction by feedsViewModel.viewActions().collectAsState(null)

    FeedsView { event ->
        feedsViewModel.obtainEvent(event)
    }

    when (viewAction) {
        FeedsAction.OpenDetailFeedScreen -> {
            outerNavController.navigate(AppScreens.Detail.title)
            feedsViewModel.clearAction()
        }

        null -> {}
    }
}