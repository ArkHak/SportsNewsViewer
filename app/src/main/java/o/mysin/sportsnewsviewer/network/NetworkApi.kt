package o.mysin.sportsnewsviewer.network

import android.util.Log
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import o.mysin.sportsnewsviewer.network.NetworkConstant.BASE_URL
import o.mysin.sportsnewsviewer.network.NetworkConstant.MESSAGE_LOG_HEADER
import o.mysin.sportsnewsviewer.network.NetworkConstant.TAG_KTOR_API

interface NetworkApi {

    companion object {
        fun create(): HttpClient {
            return HttpClient(CIO) {
                install(Logging) {
                    logger = object : Logger {
                        override fun log(message: String) {
                            Log.d(TAG_KTOR_API, "$MESSAGE_LOG_HEADER $message")
                        }
                    }
                    level = LogLevel.ALL
                }
                defaultRequest {
                    url(BASE_URL)
                }
                install(ContentNegotiation) {
                    json(
                        Json {
                            prettyPrint = true
                            isLenient = true
                            ignoreUnknownKeys = true
                        },
                    )
                }
            }
        }
    }
}