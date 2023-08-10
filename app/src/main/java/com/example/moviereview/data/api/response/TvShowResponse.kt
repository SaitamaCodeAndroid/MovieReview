package com.example.moviereview.data.api.response

data class TvShowResponse(
    val page: Int,
    val tvShows: List<TvShow>,
    val total_pages: Int,
    val total_results: Int
)