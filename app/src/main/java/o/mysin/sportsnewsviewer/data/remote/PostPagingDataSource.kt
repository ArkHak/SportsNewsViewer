package o.mysin.sportsnewsviewer.data.remote

import androidx.paging.PagingSource
import androidx.paging.PagingState
import o.mysin.sportsnewsviewer.data.mappers.dtoToUI.MapNewsItemDTOToNewsItemUI
import o.mysin.sportsnewsviewer.data.model.NewsItemUI
import o.mysin.sportsnewsviewer.data.utils.Either

internal class PostPagingDataSource(
    private val apiService: ApiService,
    private val mapNewsItemDTOToNewsItemUI: MapNewsItemDTOToNewsItemUI,
) : PagingSource<Int, NewsItemUI>() {

    override fun getRefreshKey(state: PagingState<Int, NewsItemUI>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, NewsItemUI> {
        return try {
            val page = params.key ?: 0
            val limit = 10
            val response = when (val resp =
                apiService.getNewsPagingListNetwork(startPaging = page, countPaging = limit)) {
                is Either.Fail -> emptyList()
                is Either.Success -> resp.value.listNews.map {
                    mapNewsItemDTOToNewsItemUI.transform(
                        it
                    )
                }
            }

            val nextKey = if (response.isEmpty()) null else response.size.plus(page).plus(1)
            val prevKey = if (page == 0) null else response.size.minus(limit)

            LoadResult.Page(
                data = response,
                nextKey = nextKey,
                prevKey = prevKey
            )

        } catch (e: Exception) {
            return LoadResult.Error(e)
        }
    }

}
