package com.example.moviereview.data

import com.example.moviereview.data.api.response.MovieResponse
import com.example.moviereview.data.api.response.TvShowResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

private const val VERSION_CODE = "3"

interface MovieApiService {
    /**
     * Get list of movies.
     * @see: https://developer.themoviedb.org/reference/discover-movie
     *
     * @return response of movie list.
     */
    @GET("$VERSION_CODE/discover/movie")
    suspend fun getMovies(
        @Query("api_key") apiKey: String,
        @Query("page") pageNumber: Int = 1,
    ): Response<MovieResponse>

    /**
     * Get list of TV shows.
     * @see: https://developer.themoviedb.org/reference/discover-tv
     *
     * @return response of movie list.
     */
    @GET("$VERSION_CODE/discover/tv")
    suspend fun getTvShows(
        @Query("api_key") apiKey: String,
        @Query("page") pageNumber: Int = 1,
    ): Response<TvShowResponse>
}