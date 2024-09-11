package o.mysin.sportsnewsviewer.features.detailsfeed.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.TopAppBar
import androidx.compose.material3.IconButton
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.SubcomposeAsyncImage
import coil.request.ImageRequest
import o.mysin.sportsnewsviewer.R
import o.mysin.sportsnewsviewer.features.detailsfeed.presentation.models.DetailsFeedEvent
import o.mysin.sportsnewsviewer.features.detailsfeed.presentation.models.DetailsFeedViewState
import o.mysin.sportsnewsviewer.ui.common.LoadingIndicator
import o.mysin.sportsnewsviewer.ui.theme.SportsTheme

@Composable
internal fun DetailsFeedView(
    viewState: DetailsFeedViewState,
    eventHandler: (DetailsFeedEvent) -> Unit,
) {

    //TODO ДОбавить разные иконки на добавление/удаление из списков
    Scaffold(
        topBar = {
            TopAppBar(
                modifier = Modifier,
                title = {
                    Text(
                        text = "Новость",
                        fontSize = 16.sp,
                        color = SportsTheme.colors.primaryText,
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight.SemiBold,
                        maxLines = 1,
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { eventHandler.invoke(DetailsFeedEvent.ArrowBackPressed) }) {
                        Icon(
                            painter = painterResource(R.drawable.ic_back),
                            contentDescription = "Вернуться на главный экран",
                            tint = SportsTheme.colors.secondaryText
                        )
                    }
                },
                backgroundColor = SportsTheme.colors.primaryBackground,
                actions = {
                    IconButton(onClick = { }) {
                        Icon(
                            painter = painterResource(R.drawable.ic_add_favorite),
                            contentDescription = "Добавить в избранное",
                            tint = SportsTheme.colors.accentColor
                        )
                    }
                },
                elevation = 4.dp
            )
        }
    ) { innerPadding ->

        val scrollState = rememberScrollState()
        Column(
            Modifier
                .verticalScroll(scrollState)
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp)
        ) {
            FeedHeader(
                title = viewState.newsDetails.title,
                imageSrc = viewState.newsDetails.socialImage,
            )

            Divider(
                modifier = Modifier
                    .padding(vertical = 6.dp),
                color = SportsTheme.colors.accentColor
            )

            FeedBottom(
                description = viewState.newsDetails.description,
                dateTime = viewState.newsDetails.postedTime,
            )

        }

    }

}

@Composable
private fun FeedHeader(
    title: String,
    imageSrc: String,
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
    ) {
        //TODO Нормальный дексрипшн
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            SubcomposeAsyncImage(
                modifier = Modifier
                    .height(196.dp)
                    .clip(ShapeDefaults.ExtraSmall),
                model = ImageRequest.Builder(LocalContext.current)
                    .data(imageSrc)
                    .crossfade(true)
                    .build(),
                loading = {
                    LoadingIndicator()
                },
                error = {
                    painterResource(R.drawable.not_found)
                },
                contentDescription = title,
                contentScale = ContentScale.Fit,
            )

        }

        Spacer(Modifier.height(8.dp))

        Text(
            text = title,
            color = SportsTheme.colors.primaryText,
            fontSize = 16.sp,
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.SemiBold
        )
    }
}

@Composable
private fun FeedBottom(
    description: String,
    dateTime: String,
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Text(
            text = description,
            color = SportsTheme.colors.primaryText,
            fontSize = 16.sp,
            fontFamily = FontFamily.SansSerif,
        )

        Spacer(Modifier.height(8.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(R.drawable.ic_comment),
                contentDescription = "Комменарии к посту",
                tint = SportsTheme.colors.secondaryText
            )

            Text(
                modifier = Modifier
                    .padding(horizontal = 4.dp),
                text = "33",
                fontSize = 14.sp,
                color = SportsTheme.colors.secondaryText,
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.SemiBold,
                maxLines = 1,
            )

            Spacer(modifier = Modifier.weight(1f))

            Text(
                text = dateTime,
                fontSize = 14.sp,
                color = SportsTheme.colors.secondaryText,
                fontFamily = FontFamily.SansSerif,
                maxLines = 1,
            )

        }
    }

}