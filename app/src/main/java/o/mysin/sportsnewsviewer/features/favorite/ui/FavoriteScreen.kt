package o.mysin.sportsnewsviewer.features.favorite.ui

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import o.mysin.sportsnewsviewer.base.BaseStatusScreen
import o.mysin.sportsnewsviewer.features.favorite.presentation.FavoriteViewModel
import o.mysin.sportsnewsviewer.features.favorite.presentation.models.FavoriteAction
import o.mysin.sportsnewsviewer.features.favorite.presentation.models.FavoriteEvent
import o.mysin.sportsnewsviewer.ui.common.LoadingIndicator
import org.koin.androidx.compose.koinViewModel

@Composable
internal fun FavoriteScreen(
    favoriteViewModel: FavoriteViewModel = koinViewModel(),
    feedClick: (Int) -> Unit,
) {
    val viewState by favoriteViewModel.viewStates().collectAsState()
    val viewAction by favoriteViewModel.viewActions().collectAsState(null)

    LaunchedEffect(key1 = Unit) {
        favoriteViewModel.obtainEvent(FavoriteEvent.UpdateData)
    }

    when (viewState.isStatus) {
        BaseStatusScreen.NULL -> {
            favoriteViewModel.obtainEvent(FavoriteEvent.LoadingData)
        }

        BaseStatusScreen.SUCCESS -> {
            FavoriteView(
                viewState = viewState
            ) { event ->
                favoriteViewModel.obtainEvent(event)
            }
        }

        BaseStatusScreen.LOADING -> {
            LoadingIndicator()
        }

        BaseStatusScreen.ERROR -> {}
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