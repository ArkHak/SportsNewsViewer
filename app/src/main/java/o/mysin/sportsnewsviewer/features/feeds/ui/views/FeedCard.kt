package o.mysin.sportsnewsviewer.features.feeds.ui.views

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.SubcomposeAsyncImage
import coil.request.ImageRequest
import o.mysin.sportsnewsviewer.R
import o.mysin.sportsnewsviewer.data.model.NewsItemUI
import o.mysin.sportsnewsviewer.ui.common.LoadingIndicator
import o.mysin.sportsnewsviewer.ui.theme.SportsTheme

@Composable
internal fun FeedCard(
    news: NewsItemUI,
    feedClicked: (Int) -> Unit,
) {
    Card(
        modifier = Modifier
            .padding(vertical = dimensionResource(R.dimen.extra_small_padding)),
        colors = CardColors(
            contentColor = SportsTheme.colors.primaryText,
            containerColor = SportsTheme.colors.cardBackground,
            disabledContainerColor = SportsTheme.colors.primaryBackground,
            disabledContentColor = SportsTheme.colors.primaryBackground,
        ),
        border = BorderStroke(width = 1.dp, color = Color.Gray),
        shape = ShapeDefaults.ExtraSmall,
        onClick = { feedClicked(news.id) }
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(dimensionResource(R.dimen.normal_padding_space)),
            verticalArrangement = Arrangement.Center
        ) {
            FeedCardHeader(
                title = news.title,
                imageSrc = news.socialImage
            )

            Spacer(Modifier.height(dimensionResource(R.dimen.normal_size_horizontal_spacer)))

            FeedCardBottom(
                commentCount = news.commentCount,
                dateTime = news.postedTime
            )
        }
    }
}

@Composable
private fun FeedCardHeader(
    title: String,
    imageSrc: String,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.Top,
    ) {
        SubcomposeAsyncImage(
            modifier = Modifier
                .size(dimensionResource(R.dimen.fc_height_image))
                .clip(ShapeDefaults.Small),
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
            contentScale = ContentScale.Crop,
        )

        Spacer(Modifier.width(dimensionResource(R.dimen.normal_size_horizontal_spacer)))

        Text(
            text = title,
            fontSize = 16.sp,
            color = SportsTheme.colors.primaryText,
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.SemiBold,
            maxLines = 3,
            overflow = TextOverflow.Ellipsis
        )

    }
}

@Composable
private fun FeedCardBottom(
    commentCount: String,
    dateTime: String,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(R.drawable.ic_comment),
            contentDescription = stringResource(R.string.comment_for_feed),
            tint = SportsTheme.colors.secondaryText
        )

        Text(
            modifier = Modifier
                .padding(horizontal = dimensionResource(R.dimen.extra_small_padding)),
            text = commentCount,
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