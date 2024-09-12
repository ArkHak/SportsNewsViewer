package o.mysin.sportsnewsviewer.database.mapper

import o.mysin.sportsnewsviewer.data.model.NewsDetailsUI
import o.mysin.sportsnewsviewer.database.entity.FavoriteNewsEntity

interface FavoriteNewsEntityMapper {
    fun toFavoriteNewsEntity(data: NewsDetailsUI): FavoriteNewsEntity
}