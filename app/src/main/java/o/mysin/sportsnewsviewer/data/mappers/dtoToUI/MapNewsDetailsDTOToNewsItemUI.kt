package o.mysin.sportsnewsviewer.data.mappers.dtoToUI

import o.mysin.sportsnewsviewer.base.Mapper
import o.mysin.sportsnewsviewer.data.dto.NewsDetailsDTO
import o.mysin.sportsnewsviewer.data.model.NewsItemUI
import o.mysin.sportsnewsviewer.data.utils.FormatterDate

class MapNewsDetailsDTOToNewsItemUI : Mapper<NewsDetailsDTO, NewsItemUI> {
    override fun transform(data: NewsDetailsDTO): NewsItemUI {
        return NewsItemUI(
            id = data.id,
            title = data.title,
            commentCount = data.commentCount,
            socialImage = data.socialImage,
            postedTime = FormatterDate.formatDateToStringUI(data.postedTime)
        )
    }
}