package com.example.moviereview.data.datasource

import androidx.appcompat.app.AppCompatDelegate
import com.example.moviereview.BuildConfig
import com.example.moviereview.data.service.MovieApiService
import com.example.moviereview.data.service.response.MovieResponse
import com.example.moviereview.data.service.response.TvShowResponse
import org.koin.java.KoinJavaComponent.inject
import retrofit2.Response
import java.util.Locale

class ApiDataSource {

    private val appLanguage =
        AppCompatDelegate.getApplicationLocales().get(0)?.language ?: Locale.getDefault().language

    private val service: MovieApiService by inject(MovieApiService::class.java)

    suspend fun getUpcomingMovies(): Response<MovieResponse> {
        return service.getUpcomingMovies(
            apiKey = BuildConfig.API_KEY,
            language = appLanguage,
        )
    }

    suspend fun getNowPlayingMovies(): Response<MovieResponse> {
        return service.getNowPlayingMovies(
            apiKey = BuildConfig.API_KEY,
            language = appLanguage,
        )
    }

    suspend fun getPopularMovies(): Response<MovieResponse> {
        return service.getPopularMovies(
            apiKey = BuildConfig.API_KEY,
            language = appLanguage,
        )
    }

    suspend fun getTopRateMovies(): Response<MovieResponse> {
        return service.getTopRateMovies(
            apiKey = BuildConfig.API_KEY,
            language = appLanguage,
        )
    }

    suspend fun getTrendingMovies(): Response<MovieResponse> {
        return service.getTrendingMovies(
            apiKey = BuildConfig.API_KEY,
            language = appLanguage,
        )
    }

    suspend fun getOnTheAirTvShows(): Response<TvShowResponse> {
        return service.getOnTheAirTvShows(
            apiKey = BuildConfig.API_KEY,
            language = appLanguage,
        )
    }

    suspend fun getAiringTodayTvShows(): Response<TvShowResponse> {
        return service.getAiringTodayTvShows(
            apiKey = BuildConfig.API_KEY,
            language = appLanguage,
        )
    }

    suspend fun getPopularTvShows(): Response<TvShowResponse> {
        return service.getPopularTvShows(
            apiKey = BuildConfig.API_KEY,
            language = appLanguage,
        )
    }

    suspend fun getTopRateTvShows(): Response<TvShowResponse> {
        return service.getTopRateTvShows(
            apiKey = BuildConfig.API_KEY,
            language = appLanguage,
        )
    }

    suspend fun getTrendingTvShows(): Response<TvShowResponse> {
        return service.getTrendingTvShows(
            apiKey = BuildConfig.API_KEY,
            language = appLanguage,
        )
    }
}
