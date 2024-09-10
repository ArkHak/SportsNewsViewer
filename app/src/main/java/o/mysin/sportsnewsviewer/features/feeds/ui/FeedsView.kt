package o.mysin.sportsnewsviewer.features.feeds.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import o.mysin.sportsnewsviewer.features.feeds.ui.views.FeedCard

@Composable
internal fun FeedsView(
//    viewState: NewsViewState,
//    eventHandler: (NewsEvent) -> Unit,
) {

    Column(
        modifier = Modifier
            .padding(6.dp)
    ) {
        FeedCard()
    }

}