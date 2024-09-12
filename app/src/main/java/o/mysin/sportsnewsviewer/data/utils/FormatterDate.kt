package o.mysin.sportsnewsviewer.data.utils

import o.mysin.sportsnewsviewer.base.Constants.FEED_DATE_PATTERN
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

internal object FormatterDate {
    internal fun formatDate(timestamp: String): String {
        val dateFormat =
            SimpleDateFormat(FEED_DATE_PATTERN, Locale.getDefault())
        val date = Date(timestamp.toLong() * 1000)
        return dateFormat.format(date)
    }
}