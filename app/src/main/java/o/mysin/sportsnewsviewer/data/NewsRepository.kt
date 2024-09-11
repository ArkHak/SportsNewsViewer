package o.mysin.sportsnewsviewer.data

interface NewsRepository {
    suspend fun getNews(): String
}