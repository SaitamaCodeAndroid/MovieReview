package com.example.moviereview.ui.presentation.home.model

import com.example.moviereview.data.service.response.MovieDetails

data class MovieCollection(
    val type: MovieType = MovieType.Trending,
    val movies: List<MovieDetails> = emptyList(),
)
