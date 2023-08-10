package com.example.moviereview.data

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.moviereview.BuildConfig
import com.example.moviereview.data.api.response.Movie
import retrofit2.HttpException
import java.io.IOException

private const val START_PAGE_NUMBER = 1

class MoviePagingSource(
    private val service: MovieApiService,
): PagingSource<Int, Movie>() {

    override fun getRefreshKey(state: PagingState<Int, Movie>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Movie> {
        return try {
            val nextPageNumber = params.key ?: START_PAGE_NUMBER
            val response = service.getMovies(
                apiKey = BuildConfig.API_KEY,
                pageNumber = nextPageNumber,
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

}
