package o.mysin.sportsnewsviewer.data.remote

import android.util.Log
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import o.mysin.sportsnewsviewer.data.dto.NewsDetailsDTO
import o.mysin.sportsnewsviewer.data.dto.NewsListResponseDTO
import o.mysin.sportsnewsviewer.data.utils.Either
import o.mysin.sportsnewsviewer.data.utils.HttpError
import o.mysin.sportsnewsviewer.network.NetworkConstant.ENDPOINT_GET_DETAILS_FEED
import o.mysin.sportsnewsviewer.network.NetworkConstant.ENDPOINT_GET_NEWS_LIST
import o.mysin.sportsnewsviewer.network.NetworkConstant.ERROR_REQUEST
import o.mysin.sportsnewsviewer.network.NetworkConstant.MESSAGE_LOG_HEADER_ERROR_GET_NEWS_BY_ID
import o.mysin.sportsnewsviewer.network.NetworkConstant.MESSAGE_LOG_HEADER_ERROR_GET_NEWS_LIST
import o.mysin.sportsnewsviewer.network.NetworkConstant.PAR_CATEGORY_ID
import o.mysin.sportsnewsviewer.network.NetworkConstant.PAR_COUNT
import o.mysin.sportsnewsviewer.network.NetworkConstant.PAR_FEED_ID
import o.mysin.sportsnewsviewer.network.NetworkConstant.PAR_FROM
import java.io.IOException

internal class ApiService(
    private val ktorApi: HttpClient,
) {
    suspend fun getNewsListNetwork(): Either<HttpError, NewsListResponseDTO> =
        withContext(Dispatchers.IO) {
            return@withContext try {
                val response =
                    ktorApi.get(ENDPOINT_GET_NEWS_LIST) {
                        url {
                            parameters.append(PAR_CATEGORY_ID, "208")
                            parameters.append(PAR_FROM, "0")
                            parameters.append(PAR_COUNT, "10")
                        }
                    }
                Either.success(response.body())
            } catch (e: IOException) {
                Log.d(ERROR_REQUEST, "$MESSAGE_LOG_HEADER_ERROR_GET_NEWS_LIST ${e.message}")
                Either.fail(HttpError.NetworkError())
            }
        }

    suspend fun getNewsPagingListNetwork(
        startPaging: Int,
        countPaging: Int,
    ): Either<HttpError, NewsListResponseDTO> =
        withContext(Dispatchers.IO) {
            return@withContext try {
                val response =
                    ktorApi.get(ENDPOINT_GET_NEWS_LIST) {
                        url {
                            parameters.append(PAR_CATEGORY_ID, "208")
                            parameters.append(PAR_FROM, startPaging.toString())
                            parameters.append(PAR_COUNT, countPaging.toString())
                        }
                    }
                Either.success(response.body())
            } catch (e: IOException) {
                Log.d(ERROR_REQUEST, "$MESSAGE_LOG_HEADER_ERROR_GET_NEWS_LIST ${e.message}")
                Either.fail(HttpError.NetworkError())
            }
        }

    suspend fun getNewsByIDNetwork(feedId: Int): Either<HttpError, NewsDetailsDTO> =
        withContext(Dispatchers.IO) {
            return@withContext try {
                val response =
                    ktorApi.get(ENDPOINT_GET_DETAILS_FEED) {
                        url {
                            parameters.append(PAR_FEED_ID, feedId.toString())
                        }
                    }
                Either.success(response.body())
            } catch (e: IOException) {
                Log.d(ERROR_REQUEST, "$MESSAGE_LOG_HEADER_ERROR_GET_NEWS_BY_ID ${e.message}")
                Either.fail(HttpError.NetworkError())
            }
        }
}