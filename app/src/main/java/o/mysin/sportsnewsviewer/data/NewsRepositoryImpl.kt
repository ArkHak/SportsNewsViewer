package o.mysin.sportsnewsviewer.data

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.utils.io.errors.IOException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import o.mysin.sportsnewsviewer.data.dto.NewsResponseDTO
import o.mysin.sportsnewsviewer.data.utils.Either
import o.mysin.sportsnewsviewer.data.utils.HttpError

internal class NewsRepositoryImpl(
    private val ktorApi: HttpClient,
) : NewsRepository {
    override suspend fun getNews(): Either<HttpError, NewsResponseDTO> =
        withContext(Dispatchers.IO) {
            return@withContext try {
                val response =
                    ktorApi.get("https://www.sports.ru/stat/export/iphone/news.json") {
                        url {
                            parameters.append("category_id", "208")
                            parameters.append("from", "0")
                            parameters.append("count", "10")
                        }
                    }
                Either.success(response.body())
            } catch (e: IOException) {
                Either.fail(HttpError.NetworkError())
            }
        }
}