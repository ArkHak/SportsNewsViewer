package o.mysin.sportsnewsviewer.features.detailsfeed.ui

import androidx.compose.foundation.Image
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import o.mysin.sportsnewsviewer.R
import o.mysin.sportsnewsviewer.ui.theme.SportsTheme

@Composable
internal fun DetailsFeedView(
//    viewState: NewsViewState,
//    eventHandler: (FeedsEvent) -> Unit,
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
                    IconButton(onClick = { }) {
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
                title = "«Реал» прописал отступные 1 млрд евро в контрактах Вальверде и Камавинга из-за опасений насчет предложений из Саудовской Аравии (COPE)"
            )

            Divider(
                modifier = Modifier
                    .padding(vertical = 6.dp),
                color = SportsTheme.colors.accentColor
            )

            FeedBottom(
                description = " Details Screeen asdasdas" +
                        "d asd asdasd " +
                        "asd" +
                        "a sd asdasd" +
                        "a sd" +
                        "a s" +
                        "d" +
                        "«Аль-Духайль» объявил о назначении Кристофа Гальтье на пост главного тренера.\n" +
                        "\n" +
                        "Экс-тренер «ПСЖ» заменил на этой должности аргентинца Эрнана Креспо, уволенного после 1 победы в 5 последних матчах.\n" +
                        "\n" +
                        "Кристоф Гальтье покинул «ПСЖ» в июле этого года. В сентябре сообщалось, что по поводу возможного назначения с ним общались «Наполи» и «Марсель»." +
                        "«Аль-Духайль» объявил о назначении Кристофа Гальтье на пост главного тренера.\n" +
                        "\n" +
                        "Экс-тренер «ПСЖ» заменил на этой должности аргентинца Эрнана Креспо, уволенного после 1 победы в 5 последних матчах.\n" +
                        "\n" +
                        "Кристоф Гальтье покинул «ПСЖ» в июле этого года. В сентябре сообщалось, что по поводу возможного назначения с ним общались «Наполи» и «Марсель»." +
                        "«Аль-Духайль» объявил о назначении Кристофа Гальтье на пост главного тренера.\n" +
                        "\n" +
                        "Экс-тренер «ПСЖ» заменил на этой должности аргентинца Эрнана Креспо, уволенного после 1 победы в 5 последних матчах.\n" +
                        "\n" +
                        "Кристоф Гальтье покинул «ПСЖ» в июле этого года. В сентябре сообщалось, что по поводу возможного назначения с ним общались «Наполи» и «Марсель»." +
                        "«Аль-Духайль» объявил о назначении Кристофа Гальтье на пост главного тренера.\n" +
                        "\n" +
                        "Экс-тренер «ПСЖ» заменил на этой должности аргентинца Эрнана Креспо, уволенного после 1 победы в 5 последних матчах.\n" +
                        "\n" +
                        "Кристоф Гальтье покинул «ПСЖ» в июле этого года. В сентябре сообщалось, что по поводу возможного назначения с ним общались «Наполи» и «Марсель»." +
                        "«Аль-Духайль» объявил о назначении Кристофа Гальтье на пост главного тренера.\n" +
                        "\n" +
                        "Экс-тренер «ПСЖ» заменил на этой должности аргентинца Эрнана Креспо, уволенного после 1 победы в 5 последних матчах.\n" +
                        "\n" +
                        "Кристоф Гальтье покинул «ПСЖ» в июле этого года. В сентябре сообщалось, что по поводу возможного назначения с ним общались «Наполи» и «Марсель»." +
                        "«Аль-Духайль» объявил о назначении Кристофа Гальтье на пост главного тренера.\n" +
                        "\n" +
                        "Экс-тренер «ПСЖ» заменил на этой должности аргентинца Эрнана Креспо, уволенного после 1 победы в 5 последних матчах.\n" +
                        "\n" +
                        "Кристоф Гальтье покинул «ПСЖ» в июле этого года. В сентябре сообщалось, что по поводу возможного назначения с ним общались «Наполи» и «Марсель»." +
                        "«Аль-Духайль» объявил о назначении Кристофа Гальтье на пост главного тренера.\n" +
                        "\n" +
                        "Экс-тренер «ПСЖ» заменил на этой должности аргентинца Эрнана Креспо, уволенного после 1 победы в 5 последних матчах.\n" +
                        "\n" +
                        "Кристоф Гальтье покинул «ПСЖ» в июле этого года. В сентябре сообщалось, что по поводу возможного назначения с ним общались «Наполи» и «Марсель»." +
                        "«Аль-Духайль» объявил о назначении Кристофа Гальтье на пост главного тренера.\n" +
                        "\n" +
                        "Экс-тренер «ПСЖ» заменил на этой должности аргентинца Эрнана Креспо, уволенного после 1 победы в 5 последних матчах.\n" +
                        "\n" +
                        "Кристоф Гальтье покинул «ПСЖ» в июле этого года. В сентябре сообщалось, что по поводу возможного назначения с ним общались «Наполи» и «Марсель»." +
                        "«Аль-Духайль» объявил о назначении Кристофа Гальтье на пост главного тренера.\n" +
                        "\n" +
                        "Экс-тренер «ПСЖ» заменил на этой должности аргентинца Эрнана Креспо, уволенного после 1 победы в 5 последних матчах.\n" +
                        "\n" +
                        "Кристоф Гальтье покинул «ПСЖ» в июле этого года. В сентябре сообщалось, что по поводу возможного назначения с ним общались «Наполи» и «Марсель»." +
                        "«Аль-Духайль» объявил о назначении Кристофа Гальтье на пост главного тренера.\n" +
                        "\n" +
                        "Экс-тренер «ПСЖ» заменил на этой должности аргентинца Эрнана Креспо, уволенного после 1 победы в 5 последних матчах.\n" +
                        "\n" +
                        "Кристоф Гальтье покинул «ПСЖ» в июле этого года. В сентябре сообщалось, что по поводу возможного назначения с ним общались «Наполи» и «Марсель».",
                dateTime = "10:30 10.10.2023"
            )

        }

    }

}

@Composable
private fun FeedHeader(
    title: String,
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
            Image(
                modifier = Modifier
                    .height(196.dp)
                    .clip(ShapeDefaults.ExtraSmall),
                painter = painterResource(R.drawable.test_image_post),
                contentDescription = "aaaa",
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