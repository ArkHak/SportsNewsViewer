package o.mysin.sportsnewsviewer.features.favorite.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import o.mysin.sportsnewsviewer.features.favorite.presentation.FavoriteViewModel
import o.mysin.sportsnewsviewer.features.favorite.presentation.models.FavoriteAction

@Composable
internal fun FavoriteScreen(
    favoriteViewModel: FavoriteViewModel = viewModel { FavoriteViewModel() },
    feedClick: () -> Unit,
) {
    val viewState by favoriteViewModel.viewStates().collectAsState()
    val viewAction by favoriteViewModel.viewActions().collectAsState(null)

    FavoriteView() { event ->
        favoriteViewModel.obtainEvent(event)
    }

    when (viewAction) {
        FavoriteAction.OpenDetailFeedScreen -> {
            feedClick()
            favoriteViewModel.clearAction()
        }

        null -> {}
    }
}