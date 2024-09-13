package o.mysin.sportsnewsviewer.features.detailsfeed.presentation.usecase

import o.mysin.sportsnewsviewer.data.NewsRepository
import o.mysin.sportsnewsviewer.data.mappers.uiToEntity.MapNewsDetailUiToFavoriteNewsEntity
import o.mysin.sportsnewsviewer.data.model.NewsDetailsUI

internal class ChangeExistsNewsDatabaseUseCase(
    private val repository: NewsRepository,
    private val mapNewsDetailUiToFavoriteNewsEntity: MapNewsDetailUiToFavoriteNewsEntity,
) {
    suspend operator fun invoke(news: NewsDetailsUI) {
        val isExistsInDatabase = repository.checkExistsFavoritesNewsInDatabase(news.id)

        if (isExistsInDatabase) {
            repository.removeFavoriteNews(news.id)
        } else {
            val currentNewsSave = mapNewsDetailUiToFavoriteNewsEntity.transform(news)
            repository.saveFavoriteNews(currentNewsSave)
        }

    }
}
