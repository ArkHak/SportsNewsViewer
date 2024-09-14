package o.mysin.sportsnewsviewer.features.favorite.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import o.mysin.sportsnewsviewer.R
import o.mysin.sportsnewsviewer.features.favorite.presentation.models.FavoriteEvent
import o.mysin.sportsnewsviewer.features.favorite.presentation.models.FavoriteViewState
import o.mysin.sportsnewsviewer.features.feeds.ui.views.FeedCard
import o.mysin.sportsnewsviewer.ui.theme.SportsTheme

@Composable
internal fun FavoriteView(
    viewState: FavoriteViewState,
    eventHandler: (FavoriteEvent) -> Unit,
) {

    Column(
        Modifier
            .fillMaxSize()
            .background(color = SportsTheme.colors.primaryBackground)
            .padding(dimensionResource(R.dimen.small_padding_space)),
    ) {
        LazyColumn(
            modifier = Modifier
        ) {
            items(viewState.favoriteNewsList) { newsItem ->
                FeedCard(newsItem) { feedId ->
                    eventHandler.invoke(FavoriteEvent.FeedClicked(feedId = feedId))
                }
            }
        }

    }
}