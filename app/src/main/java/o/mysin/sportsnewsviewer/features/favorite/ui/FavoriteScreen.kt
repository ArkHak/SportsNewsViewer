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
    feedClick: (Int) -> Unit,
) {
    val viewState by favoriteViewModel.viewStates().collectAsState()
    val viewAction by favoriteViewModel.viewActions().collectAsState(null)

    FavoriteView(
        viewState = viewState
    ) { event ->
        favoriteViewModel.obtainEvent(event)
    }

    when (viewAction) {
        null -> {}
        is FavoriteAction.OpenDetailFeedScreen -> {
            val id = (viewAction as FavoriteAction.OpenDetailFeedScreen).feedId
            feedClick(id)
            favoriteViewModel.clearAction()

        }
    }
}