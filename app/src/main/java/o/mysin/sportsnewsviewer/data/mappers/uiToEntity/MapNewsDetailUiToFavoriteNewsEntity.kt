package o.mysin.sportsnewsviewer.data.mappers.uiToEntity

import o.mysin.sportsnewsviewer.base.Mapper
import o.mysin.sportsnewsviewer.data.model.NewsDetailsUI
import o.mysin.sportsnewsviewer.data.utils.FormatterDate
import o.mysin.sportsnewsviewer.database.entity.FavoriteNewsEntity

class MapNewsDetailUiToFavoriteNewsEntity : Mapper<NewsDetailsUI, FavoriteNewsEntity> {
    override fun transform(data: NewsDetailsUI): FavoriteNewsEntity {
        return FavoriteNewsEntity(
            newsId = data.id,
            titleNews = data.title,
            postedTime = FormatterDate.formatDateToTimestampLong(data.postedTime)
        )
    }
}
