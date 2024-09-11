package o.mysin.sportsnewsviewer.data.mappers

import o.mysin.sportsnewsviewer.base.Mapper
import o.mysin.sportsnewsviewer.data.dto.NewsItemDTO
import o.mysin.sportsnewsviewer.data.model.NewsItemUI
import o.mysin.sportsnewsviewer.data.utils.FormatterDate

class MapNewsItemDTOToNewsItemUI : Mapper<NewsItemDTO, NewsItemUI> {
    override fun transform(data: NewsItemDTO): NewsItemUI {
        return NewsItemUI(
            id = data.id,
            title = data.title,
            commentCount = data.commentCount,
            socialImage = data.socialImage,
            postedTime = FormatterDate.formatDate(data.postedTime)
        )
    }
}