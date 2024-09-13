package o.mysin.sportsnewsviewer.utils

object IsEqualsTwoList {
    fun <T> isEqualsTwoList(first: List<T>, second: List<T>): Boolean {
        if (first.size != second.size) {
            return false
        }

        return first.zip(second).all { (x, y) -> x == y }
    }
}