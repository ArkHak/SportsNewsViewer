package o.mysin.sportsnewsviewer.data.utils

import o.mysin.sportsnewsviewer.base.Constants.FEED_DATE_PATTERN
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

internal object FormatterDate {
    internal fun formatDateToStringUI(timestamp: String): String {
        val dateFormat =
            SimpleDateFormat(FEED_DATE_PATTERN, Locale.getDefault())
        val date = Date(timestamp.toLong() * 1000)
        return dateFormat.format(date)
    }

    internal fun formatDateBDToStringUI(timestamp: String): String {
        val dateFormat =
            SimpleDateFormat(FEED_DATE_PATTERN, Locale.getDefault())
        val date = Date(timestamp.toLong())
        return dateFormat.format(date)
    }

    internal fun formatDateToTimestampLong(dateString: String): Long {
        val dateFormat = SimpleDateFormat(FEED_DATE_PATTERN, Locale.getDefault())
        return try {
            dateFormat.parse(dateString)?.time ?: 0
        } catch (e: Exception) {
            0
        }
    }
}