package o.mysin.sportsnewsviewer.features.settings.presentation.usecase

import o.mysin.sportsnewsviewer.data.NewsRepository

internal class ClearFavoriteNewsDatabaseUseCase(
    private val repository: NewsRepository,
) {
    suspend operator fun invoke() = repository.clearFavoriteNewsDatabase()
}