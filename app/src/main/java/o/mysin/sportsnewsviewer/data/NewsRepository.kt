package o.mysin.sportsnewsviewer.data

import o.mysin.sportsnewsviewer.data.utils.Either
import o.mysin.sportsnewsviewer.data.utils.HttpError

interface NewsRepository {
    suspend fun getNews(): Either<HttpError, NewsResponse>
}