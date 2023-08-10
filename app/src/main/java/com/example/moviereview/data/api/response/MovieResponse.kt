package com.example.moviereview.data.api.response

data class MovieResponse(
    val page: Int,
    val movies: List<Movie>,
    val total_pages: Int,
    val total_results: Int
)
