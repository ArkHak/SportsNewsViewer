package o.mysin.sportsnewsviewer.features.navigations

import kotlinx.serialization.Serializable

internal sealed class AppScreens {
    @Serializable
    data object Main : AppScreens()

    @Serializable
    data class Detail(val feedId: Int) : AppScreens()
}