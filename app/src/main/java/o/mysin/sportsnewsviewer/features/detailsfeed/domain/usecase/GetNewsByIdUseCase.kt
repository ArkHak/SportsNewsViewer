package o.mysin.sportsnewsviewer.features.detailsfeed.domain.usecase

import o.mysin.sportsnewsviewer.data.NewsRepository
import o.mysin.sportsnewsviewer.data.dto.NewsDetailsDTO
import o.mysin.sportsnewsviewer.data.utils.Either
import o.mysin.sportsnewsviewer.data.utils.HttpError

internal class GetNewsByIdUseCase(
    private val repository: NewsRepository,
) {
    suspend operator fun invoke(feedId: Int): Either<HttpError, NewsDetailsDTO> =
        repository.getNewsByID(feedId)
}
