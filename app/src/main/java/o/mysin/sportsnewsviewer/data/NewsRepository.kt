package o.mysin.sportsnewsviewer.data

import o.mysin.sportsnewsviewer.data.dto.NewsResponseDTO
import o.mysin.sportsnewsviewer.data.utils.Either
import o.mysin.sportsnewsviewer.data.utils.HttpError

interface NewsRepository {
    suspend fun getNews(): Either<HttpError, NewsResponseDTO>
}