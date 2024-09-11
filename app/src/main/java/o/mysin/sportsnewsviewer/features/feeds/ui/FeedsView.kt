package o.mysin.sportsnewsviewer.features.feeds.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import o.mysin.sportsnewsviewer.features.feeds.presentation.models.FeedsEvent
import o.mysin.sportsnewsviewer.features.feeds.presentation.models.FeedsViewState
import o.mysin.sportsnewsviewer.features.feeds.ui.views.FeedCard

@Composable
internal fun FeedsView(
    viewState: FeedsViewState,
    eventHandler: (FeedsEvent) -> Unit,
) {

    Column(
        modifier = Modifier
            .padding(6.dp)
    ) {
        LazyColumn {
            items(viewState.newsList) { newsItem ->
                FeedCard(newsItem) { feedId ->
                    eventHandler.invoke(FeedsEvent.FeedClicked(feedId))
                }
            }
        }
    }

}