package o.mysin.sportsnewsviewer.data.mappers

import o.mysin.sportsnewsviewer.base.Mapper
import o.mysin.sportsnewsviewer.data.dto.NewsDetailsDTO
import o.mysin.sportsnewsviewer.data.model.NewsDetailsUI
import o.mysin.sportsnewsviewer.data.utils.FormatterDate

class MapNewsDetailsDTOToNewsDetailsUI : Mapper<NewsDetailsDTO, NewsDetailsUI> {
    override fun transform(data: NewsDetailsDTO): NewsDetailsUI {
        return NewsDetailsUI(
            id = data.id,
            title = data.title,
            commentCount = data.commentCount,
            socialImage = data.socialImage,
            postedTime = FormatterDate.formatDate(data.postedTime),
            description = data.description
        )
    }
}