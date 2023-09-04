package com.example.moviereview.data.service

import com.example.moviereview.data.service.response.MovieResponse
import com.example.moviereview.data.service.response.TvShowResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

private const val VERSION_CODE = "3"

interface MovieApiService {

    // Movies
    /**
     * Get a list of movies that are being released soon.
     * @see: https://developer.themoviedb.org/reference/movie-upcoming-list
     *
     * @return response of upcoming movies.
     */
    @GET("$VERSION_CODE/movie/upcoming")
    suspend fun getUpcomingMovies(
        @Query("api_key") apiKey: String,
        @Query("language") language: String,
    ): Response<MovieResponse>

    /**
     * Get a list of movies that are currently in theatres.
     * @see: https://developer.themoviedb.org/reference/movie-now-playing-list
     *
     * @return response of now playing movies.
     */
    @GET("$VERSION_CODE/movie/now_playing")
    suspend fun getNowPlayingMovies(
        @Query("api_key") apiKey: String,
        @Query("language") language: String,
    ): Response<MovieResponse>

    /**
     * Get a list of movies ordered by popularity.
     * @see: https://developer.themoviedb.org/reference/movie-popular-list
     *
     * @return response of most viewed movies.
     */
    @GET("$VERSION_CODE/movie/popular")
    suspend fun getPopularMovies(
        @Query("api_key") apiKey: String,
        @Query("language") language: String,
    ): Response<MovieResponse>

    /**
     * Get a list of movies ordered by rating.
     * @see: https://developer.themoviedb.org/reference/movie-top-rated-list
     *
     * @return response of top rated movies.
     */
    @GET("$VERSION_CODE/movie/top_rated")
    suspend fun getTopRateMovies(
        @Query("api_key") apiKey: String,
        @Query("language") language: String,
    ): Response<MovieResponse>

    /**
     * Get the trending movies.
     * @see: https://developer.themoviedb.org/reference/trending-movies
     *
     * @return response of trending movies in this week.
     */
    @GET("$VERSION_CODE/trending/movie/{time_window}")
    suspend fun getTrendingMovies(
        @Path("time_window") timeWindow: String = "week",
        @Query("api_key") apiKey: String,
        @Query("language") language: String,
    ): Response<MovieResponse>

    // TV SHOWS
    /**
     * Get a list of TV shows that air in the next 7 days.
     * @see: https://developer.themoviedb.org/reference/tv-series-on-the-air-list
     *
     * @return response of on the air tv shows.
     */
    @GET("$VERSION_CODE/tv/on_the_air")
    suspend fun getOnTheAirTvShows(
        @Query("api_key") apiKey: String,
        @Query("language") language: String,
    ): Response<TvShowResponse>

    /**
     * Get a list of TV shows airing today.
     * @see: https://developer.themoviedb.org/reference/tv-series-airing-today-list
     *
     * @return response of tv shows will be airing today.
     */
    @GET("$VERSION_CODE/tv/airing_today")
    suspend fun getAiringTodayTvShows(
        @Query("api_key") apiKey: String,
        @Query("language") language: String,
    ): Response<TvShowResponse>

    /**
     * Get a list of TV shows ordered by popularity.
     * @see: https://developer.themoviedb.org/reference/tv-series-popular-list
     *
     * @return response of Popular tv shows.
     */
    @GET("$VERSION_CODE/tv/popular")
    suspend fun getPopularTvShows(
        @Query("api_key") apiKey: String,
        @Query("language") language: String,
    ): Response<TvShowResponse>

    /**
     * Get a list of TV shows ordered by rating.
     * @see: https://developer.themoviedb.org/reference/tv-series-top-rated-list
     *
     * @return response of Popular tv shows.
     */
    @GET("$VERSION_CODE/tv/top_rated")
    suspend fun getTopRateTvShows(
        @Query("api_key") apiKey: String,
        @Query("language") language: String,
    ): Response<TvShowResponse>

    /**
     * Get the trending TV shows.
     * @see: https://developer.themoviedb.org/reference/trending-tv
     *
     * @return response of trending tv shows  in this week.
     */
    @GET("$VERSION_CODE/trending/tv/{time_window}")
    suspend fun getTrendingTvShows(
        @Path("time_window") timeWindow: String = "week",
        @Query("api_key") apiKey: String,
        @Query("language") language: String,
    ): Response<TvShowResponse>
}