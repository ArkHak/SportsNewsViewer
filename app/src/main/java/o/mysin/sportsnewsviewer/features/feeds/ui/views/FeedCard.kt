package o.mysin.sportsnewsviewer.features.feeds.ui.views

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import o.mysin.sportsnewsviewer.R
import o.mysin.sportsnewsviewer.ui.theme.SportsTheme

@Composable
fun FeedCard() {

    Card(
        colors = CardColors(
            contentColor = SportsTheme.colors.primaryBackground,
            containerColor = SportsTheme.colors.primaryBackground,
            disabledContainerColor = SportsTheme.colors.primaryBackground,
            disabledContentColor = SportsTheme.colors.primaryBackground,
        ),
        border = BorderStroke(width = 1.dp, color = Color.Gray),
        shape = ShapeDefaults.ExtraSmall
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            verticalArrangement = Arrangement.Center
        ) {
            //TODO Вставить релевантные значение из вне
            PostCardHeader(
                title = "Текст новости",
                imageSrc = " "
            )

            Spacer(Modifier.height(14.dp))

            PostCardBottom(
                dateTime = "10:30 10.10.2023"
            )
        }
    }
}

@Composable
private fun PostCardHeader(
    title: String,
    imageSrc: String,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.Top,
    ) {
        Image(
            modifier = Modifier
                .size(80.dp)
                .clip(ShapeDefaults.Small),
            painter = painterResource(R.drawable.test_image_post),
            contentDescription = title,
            contentScale = ContentScale.Crop
        )

        Spacer(Modifier.width(14.dp))

        Text(
            text = title,
            color = SportsTheme.colors.primaryText,
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.SemiBold,
            maxLines = 3,
            overflow = TextOverflow.Ellipsis
        )

    }
}

@Composable
private fun PostCardBottom(
    dateTime: String,
) {
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
            color = SportsTheme.colors.secondaryText,
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.SemiBold,
            maxLines = 1,
        )

        Spacer(modifier = Modifier.weight(1f))

        Text(
            text = dateTime,
            color = SportsTheme.colors.secondaryText,
            fontFamily = FontFamily.SansSerif,
            maxLines = 1,
        )

    }
}

@Preview
@Composable
private fun FeedCardPreview() {
    FeedCard()
}