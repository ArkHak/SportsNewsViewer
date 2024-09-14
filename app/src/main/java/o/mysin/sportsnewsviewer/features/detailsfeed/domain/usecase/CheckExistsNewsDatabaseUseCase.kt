package o.mysin.sportsnewsviewer.features.detailsfeed.domain.usecase

import o.mysin.sportsnewsviewer.data.NewsRepository

internal class CheckExistsNewsDatabaseUseCase(
    private val repository: NewsRepository,
) {
    suspend operator fun invoke(newsId: Int) =
        repository.checkExistsFavoritesNewsInDatabase(newsId)
}
