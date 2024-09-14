package o.mysin.sportsnewsviewer.features.settings.domain.usecase

import o.mysin.sportsnewsviewer.data.NewsRepository

internal class ClearFavoriteNewsDatabaseUseCase(
    private val repository: NewsRepository,
) {
    suspend operator fun invoke() = repository.clearFavoriteNewsDatabase()
}