package o.mysin.sportsnewsviewer.ui.common

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import o.mysin.sportsnewsviewer.R
import o.mysin.sportsnewsviewer.ui.theme.SportsTheme

@Composable
internal fun LoadingIndicator() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CircularProgressIndicator(
            modifier = Modifier.size(dimensionResource(R.dimen.size_loading_indicator)),
            color = SportsTheme.colors.accentColor,
            trackColor = SportsTheme.colors.secondaryBackground,
        )
    }

}