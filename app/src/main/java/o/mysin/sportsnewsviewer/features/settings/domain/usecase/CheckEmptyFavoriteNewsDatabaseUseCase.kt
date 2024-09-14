package o.mysin.sportsnewsviewer.features.settings.domain.usecase

import o.mysin.sportsnewsviewer.data.NewsRepository

internal class CheckEmptyFavoriteNewsDatabaseUseCase(
    private val repository: NewsRepository,
) {
    suspend operator fun invoke(): Boolean {
        val countEntry = repository.getCountEntryFavoriteDatabase()
        return (countEntry == 0)
    }
}
