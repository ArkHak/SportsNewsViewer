package o.mysin.sportsnewsviewer.network

internal object NetworkConstant {

    const val BASE_URL = "https://www.sports.ru/"

    //Network message log header
    const val MESSAGE_LOG_HEADER = "KtorApi:"
    const val MESSAGE_LOG_HEADER_ERROR_GET_NEWS_LIST = "Error request - GetNewsList:"
    const val MESSAGE_LOG_HEADER_ERROR_GET_NEWS_BY_ID = "Error request - GetNewsByID:"

    //Network tags
    const val TAG_KTOR_API = "KtorClientTag"
    const val ERROR_REQUEST = "ERROR_REQUEST"

    //Endpoints requests
    const val ENDPOINT_GET_NEWS_LIST = "/stat/export/iphone/news.json"
    const val ENDPOINT_GET_DETAILS_FEED = "/stat/export/iphone/news_item.json"

    //Parameters request
    const val PAR_CATEGORY_ID = "category_id"
    const val PAR_FEED_ID = "id"
    const val PAR_FROM = "from"
    const val PAR_COUNT = "count"
}