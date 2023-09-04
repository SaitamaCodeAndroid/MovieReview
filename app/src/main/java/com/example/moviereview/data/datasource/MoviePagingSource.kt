package com.example.moviereview.data.datasource


/*
private const val START_PAGE_NUMBER = 1
class MoviePagingSource(
    private val service: MovieApiService,
): PagingSource<Int, MovieResponse>() {

    override fun getRefreshKey(state: PagingState<Int, MovieResponse>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, MovieResponse> {
        return try {
            val nextPageNumber = params.key ?: START_PAGE_NUMBER
            val response = service.getUpcomingMovies(
                apiKey = BuildConfig.API_KEY,
                "vi"
            )

            LoadResult.Page(
                data = response.body()?.movies ?: listOf(),
                prevKey = null,
                nextKey = (response.body()?.page ?: nextPageNumber) + 1
            )
        } catch (e: IOException) {
            // IOException for network failures.
            LoadResult.Error(e)
        } catch (e: HttpException) {
            // HttpException for any non-2xx HTTP status codes.
            LoadResult.Error(e)
        }
    }

}*/
