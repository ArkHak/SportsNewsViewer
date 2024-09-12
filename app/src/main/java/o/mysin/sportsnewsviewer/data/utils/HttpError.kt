package o.mysin.sportsnewsviewer.data.utils

import androidx.annotation.StringRes
import o.mysin.sportsnewsviewer.R

sealed interface HttpError {

    data class NetworkError(
        @StringRes
        val errorMessage: Int = R.string.error_network,
    ) : HttpError

}