package o.mysin.sportsnewsviewer.features.feeds.presentation.usecase

import o.mysin.sportsnewsviewer.data.NewsRepository
import o.mysin.sportsnewsviewer.data.dto.NewsListResponseDTO
import o.mysin.sportsnewsviewer.data.utils.Either
import o.mysin.sportsnewsviewer.data.utils.HttpError

internal class GetNewsListUseCase(
    private val repository: NewsRepository,
) {
    suspend operator fun invoke(): Either<HttpError, NewsListResponseDTO> = repository.getNewsList()
}