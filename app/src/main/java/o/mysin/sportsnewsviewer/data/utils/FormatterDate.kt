package o.mysin.sportsnewsviewer.data.utils

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

internal object FormatterDate {
    internal fun formatDate(timestamp: String): String {
        val dateFormat = SimpleDateFormat("HH:mm dd.MM.yyyy", Locale.getDefault())
        val date = Date(timestamp.toLong() * 1000)
        return dateFormat.format(date)
    }
}