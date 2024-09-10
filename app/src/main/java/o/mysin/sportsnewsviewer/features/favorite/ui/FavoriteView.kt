package o.mysin.sportsnewsviewer.features.favorite.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import o.mysin.sportsnewsviewer.features.feeds.ui.views.FeedCard

@Composable
internal fun FavoriteView(
//    viewState: FavoriteViewState,
//    eventHandler: (NewsEvent) -> Unit,
) {

    Column(
        modifier = Modifier
            .padding(6.dp)
    ) {
        LazyColumn {
            items(2) {
                FeedCard {
                    // eventHandler.invoke(FeedsEvent.FeedClicked)
                }
            }
        }
    }
}