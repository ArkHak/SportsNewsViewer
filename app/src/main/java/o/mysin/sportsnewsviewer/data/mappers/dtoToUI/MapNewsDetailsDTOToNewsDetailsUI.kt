package o.mysin.sportsnewsviewer.data.mappers.dtoToUI

import android.text.Html
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
            postedTime = FormatterDate.formatDateToStringUI(data.postedTime),
            description = clearHtml(data.description),
        )
    }
}

private fun clearHtml(htmlText: String): String {
    val dirtyText = Html.fromHtml(htmlText, Html.FROM_HTML_MODE_LEGACY).toString()
    return getSubStringAfterFirstNewLine(dirtyText).trim()
}

private fun getSubStringAfterFirstNewLine(text: String): String {
    val newLineIndex = text.indexOf('\n')
    return if (newLineIndex != -1) {
        text.substring(newLineIndex + 1)
    } else {
        text
    }
}