package o.mysin.sportsnewsviewer.base

internal interface Mapper<SRC, DST> {
    fun transform(data: SRC): DST
}