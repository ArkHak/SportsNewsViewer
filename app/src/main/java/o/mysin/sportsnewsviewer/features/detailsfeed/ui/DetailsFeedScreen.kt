package o.mysin.sportsnewsviewer.features.detailsfeed.ui

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import o.mysin.sportsnewsviewer.features.detailsfeed.presentation.DetailsFeedViewModel
import o.mysin.sportsnewsviewer.features.detailsfeed.presentation.models.DetailsFeedAction
import o.mysin.sportsnewsviewer.features.detailsfeed.presentation.models.DetailsFeedEvent
import o.mysin.sportsnewsviewer.features.feeds.presentation.models.StatusScreen
import o.mysin.sportsnewsviewer.ui.common.LoadingIndicator
import org.koin.androidx.compose.koinViewModel

@Composable
internal fun DetailsFeedScreen(
    feedId: Int,
    detailsFeedViewModel: DetailsFeedViewModel = koinViewModel(),
    arrowBackPressed: () -> Unit,
) {
    val viewState by detailsFeedViewModel.viewStates().collectAsState()
    val viewAction by detailsFeedViewModel.viewActions().collectAsState(null)

    when (viewState.isStatus) {
        StatusScreen.NULL -> {
            detailsFeedViewModel.obtainEvent(DetailsFeedEvent.LoadingData(feedId))
        }

        StatusScreen.SUCCESS -> {
            DetailsFeedView(
                viewState = viewState
            ) { event ->
                detailsFeedViewModel.obtainEvent(event)
            }
        }

        StatusScreen.LOADING -> {
            LoadingIndicator()
        }

        StatusScreen.ERROR -> TODO()
    }

    when (viewAction) {
        DetailsFeedAction.BackMainScreen -> {
            arrowBackPressed()
            detailsFeedViewModel.clearAction()
        }

        is DetailsFeedAction.PutToast -> {
            val messageId = (viewAction as DetailsFeedAction.PutToast).messageIdRes
            Toast.makeText(
                LocalContext.current,
                stringResource(messageId),
                Toast.LENGTH_SHORT
            ).show()
            detailsFeedViewModel.clearAction()
        }

        null -> {}
    }
}