package o.mysin.sportsnewsviewer.features.detailsfeed.presentation.usecase

import o.mysin.sportsnewsviewer.data.NewsRepository
import o.mysin.sportsnewsviewer.data.model.NewsDetailsUI

internal class SaveNewsDatabaseUseCase(
    private val repository: NewsRepository,
) {
    suspend operator fun invoke(news: NewsDetailsUI) =
        repository.saveFavoriteNews(news)
}
