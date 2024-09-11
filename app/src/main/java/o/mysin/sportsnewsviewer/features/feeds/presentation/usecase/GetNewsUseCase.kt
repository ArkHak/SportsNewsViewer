package o.mysin.sportsnewsviewer.features.feeds.presentation.usecase

import o.mysin.sportsnewsviewer.data.NewsRepository
import o.mysin.sportsnewsviewer.data.dto.NewsResponseDTO
import o.mysin.sportsnewsviewer.data.utils.Either
import o.mysin.sportsnewsviewer.data.utils.HttpError

internal class GetNewsUseCase(
    private val repository: NewsRepository,
) {
    suspend operator fun invoke(): Either<HttpError, NewsResponseDTO> = repository.getNews()
}

//internal class GetAllArticlesUseCase @Inject constructor(
//    private val repository: ArticlesRepository
//) {
//    operator fun invoke(query: String): Flow<RequestResult<List<ArticleUI>>> {
//        return repository.getAll(query).map { requestResult ->
//            requestResult.map { articles -> articles.map { it.toUiArticle() } }
//        }
//    }
//}

//class BookTripUseCase(
//    private val repository: HomePassengerRepository,
//) {
//    suspend operator fun invoke(bookingTripInfo: BookingTripInfo) =
//        repository.bookTrip(bookingTripInfo)
//}