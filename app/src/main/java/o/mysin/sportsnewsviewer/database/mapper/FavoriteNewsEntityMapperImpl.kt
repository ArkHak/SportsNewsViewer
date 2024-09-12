package o.mysin.sportsnewsviewer.database.mapper

import o.mysin.sportsnewsviewer.data.model.NewsDetailsUI
import o.mysin.sportsnewsviewer.database.entity.FavoriteNewsEntity

class FavoriteNewsEntityMapperImpl : FavoriteNewsEntityMapper {

    override fun toFavoriteNewsEntity(data: NewsDetailsUI): FavoriteNewsEntity {
        return FavoriteNewsEntity(
            newsId = data.id,
            titleNews = data.title
        )
    }
}