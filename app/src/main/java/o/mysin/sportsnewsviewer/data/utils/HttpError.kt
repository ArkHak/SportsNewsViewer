package o.mysin.sportsnewsviewer.data.utils

sealed interface HttpError {

    data class NetworkError(
        val errorMessage: String = "Ошибка сети",
    ) : HttpError

}