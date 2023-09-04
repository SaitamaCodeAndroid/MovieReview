package com.example.moviereview.domain.home

import com.example.moviereview.data.repository.HomeRepository
import com.example.moviereview.data.service.response.MovieDetails
import com.example.moviereview.ui.presentation.home.model.MovieCollection
import com.example.moviereview.ui.presentation.home.model.MovieType
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine

/**
 * Call 5 api request at once and transform to a list of dynamic movies.
 * Each element that is a movie collection, is displayed in a row.
 */
class MovieInteractor(private val homeRepository: HomeRepository) {

    fun getMovieCollections(): Flow<List<MovieCollection>> {

        val movieCollections = mutableListOf<MovieCollection>()

        return combine(
            homeRepository.getUpcomingMovies(),
            homeRepository.getNowPlayingMovies(),
            homeRepository.getPopularMovies(),
            homeRepository.getTopRateMovies(),
            homeRepository.getTrendingMovies(),
        ) { flows ->

            flows.forEachIndexed { index, response ->
                val type = when (index) {
                    0 -> MovieType.Upcoming
                    1 -> MovieType.NowPlaying
                    2 -> MovieType.Popular
                    3 -> MovieType.TopRate
                    else -> MovieType.Trending
                }
                val movies = if (response.isSuccessful) {
                    response.body()
                        ?.fromMovieToMovieDetailsList()
                        ?.getFirstThirtyMoviesList(type)
                        ?: MovieCollection()
                } else {
                    MovieCollection()
                }
                movieCollections.add(movies)
            }

            movieCollections
        }
    }

    fun getTvShowCollections(): Flow<List<MovieCollection>> {

        val movieCollections = mutableListOf<MovieCollection>()

        return combine(
            homeRepository.getOnTheAirTvShows(),
            homeRepository.getAiringTodayTvShows(),
            homeRepository.getPopularTvShows(),
            homeRepository.getTopRateTvShows(),
            homeRepository.getTrendingTvShows(),
        ) { flows ->

            flows.forEachIndexed { index, response ->
                val type = when (index) {
                    0 -> MovieType.OnTheAir
                    1 -> MovieType.AiringToday
                    2 -> MovieType.Popular
                    3 -> MovieType.TopRate
                    else -> MovieType.Trending
                }
                val movies = if (response.isSuccessful) {
                    response.body()
                        ?.fromTvShowToMovieDetailsList()
                        ?.getFirstThirtyMoviesList(type)
                        ?: MovieCollection()
                } else {
                    MovieCollection()
                }
                movieCollections.add(movies)
            }

            movieCollections
        }
    }
}

private fun List<MovieDetails>.getFirstThirtyMoviesList(
    type: MovieType
): MovieCollection {
    val quantities = if (type == MovieType.OnTheAir) {
        10
    } else {
        30
    }
    return this.let { movies ->
        MovieCollection(
            type = type,
            movies = if (movies.size >= quantities) {
                movies.shuffled().slice(0..quantities)
            } else {
                movies.shuffled()
            }
        )
    }
}
