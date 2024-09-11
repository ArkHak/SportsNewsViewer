package o.mysin.sportsnewsviewer.features.detailsfeed.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import o.mysin.sportsnewsviewer.features.detailsfeed.presentation.DetailsFeedViewModel
import o.mysin.sportsnewsviewer.features.detailsfeed.presentation.models.DetailsFeedAction

@Composable
internal fun DetailsFeedScreen(
    detailsFeedViewModel: DetailsFeedViewModel = viewModel { DetailsFeedViewModel() },
    arrowBackPressed: () -> Unit,
) {
    val viewState by detailsFeedViewModel.viewStates().collectAsState()
    val viewAction by detailsFeedViewModel.viewActions().collectAsState(null)

    DetailsFeedView { event ->
        detailsFeedViewModel.obtainEvent(event)
    }

    when (viewAction) {
        DetailsFeedAction.BackMainScreen -> {
            arrowBackPressed()
            detailsFeedViewModel.clearAction()
        }

        null -> {}
    }
}