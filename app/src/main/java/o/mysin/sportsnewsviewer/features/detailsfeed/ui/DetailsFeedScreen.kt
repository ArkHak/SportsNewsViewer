package o.mysin.sportsnewsviewer.features.detailsfeed.ui

import android.util.Log
import androidx.compose.runtime.Composable
import o.mysin.sportsnewsviewer.features.navigations.LocalNavHost

@Composable
internal fun DetailsFeedScreen(
) {

    val outerNavController = LocalNavHost.current
    Log.d("TAGaaaa", "DetailsFeedScreen: ${outerNavController}")
    DetailsFeedView()
}