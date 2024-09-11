package o.mysin.sportsnewsviewer.data

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.utils.io.errors.IOException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import o.mysin.sportsnewsviewer.data.dto.NewsDetailsDTO
import o.mysin.sportsnewsviewer.data.dto.NewsListResponseDTO
import o.mysin.sportsnewsviewer.data.utils.Either
import o.mysin.sportsnewsviewer.data.utils.HttpError

internal class NewsRepositoryImpl(
    private val ktorApi: HttpClient,
) : NewsRepository {

    //TODO Добавить Логер Ошибок
    override suspend fun getNewsList(): Either<HttpError, NewsListResponseDTO> =
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

    override suspend fun getNewsByID(feedId: Int): Either<HttpError, NewsDetailsDTO> =
        withContext(Dispatchers.IO) {
            return@withContext try {
                val response =
                    ktorApi.get("https://www.sports.ru/stat/export/iphone/news_item.json") {
                        url {
                            parameters.append("id", feedId.toString())
                        }
                    }
                Either.success(response.body())
            } catch (e: IOException) {
                Either.fail(HttpError.NetworkError())
            }
        }
}