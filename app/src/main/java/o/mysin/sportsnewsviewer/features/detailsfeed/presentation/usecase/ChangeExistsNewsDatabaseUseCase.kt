package o.mysin.sportsnewsviewer.features.detailsfeed.presentation.usecase

import o.mysin.sportsnewsviewer.data.NewsRepository
import o.mysin.sportsnewsviewer.data.model.NewsDetailsUI

internal class ChangeExistsNewsDatabaseUseCase(
    private val repository: NewsRepository,
) {
    suspend operator fun invoke(news: NewsDetailsUI) {
        val isExistsInDatabase = repository.checkExistsFavoritesNewsInDatabase(news.id)

        if (isExistsInDatabase) {
            repository.removeFavoriteNews(news.id)
        } else {
            repository.saveFavoriteNews(news)
        }

    }
}
