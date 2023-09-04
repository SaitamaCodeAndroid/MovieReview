package com.example.moviereview.data.repository

import com.example.moviereview.data.datasource.ApiDataSource
import kotlinx.coroutines.flow.flow

class HomeRepository(private val dataSource: ApiDataSource) {

    /**
     * Return list of movie collections to show on home screen.
     */
    fun getUpcomingMovies() = flow {
        emit(
            dataSource.getUpcomingMovies()
        )
    }

    fun getNowPlayingMovies() = flow {
        emit(
            dataSource.getNowPlayingMovies()
        )
    }

    fun getPopularMovies() = flow {
        emit(
            dataSource.getPopularMovies()
        )
    }

    fun getTopRateMovies() = flow {
        emit(
            dataSource.getTopRateMovies()
        )
    }

    fun getTrendingMovies() = flow {
        emit(
            dataSource.getTrendingMovies()
        )
    }

    /**
     * Return list of tv series collections to show on home screen.
     */

    fun getOnTheAirTvShows() = flow {
        emit(
            dataSource.getOnTheAirTvShows()
        )
    }

    fun getAiringTodayTvShows() = flow {
        emit(
            dataSource.getAiringTodayTvShows()
        )
    }

    fun getPopularTvShows() = flow {
        emit(
            dataSource.getPopularTvShows()
        )
    }

    fun getTopRateTvShows() = flow {
        emit(
            dataSource.getTopRateTvShows()
        )
    }

    fun getTrendingTvShows() = flow {
        emit(
            dataSource.getTrendingTvShows()
        )
    }
}
