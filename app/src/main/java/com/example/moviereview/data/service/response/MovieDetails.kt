package com.example.moviereview.data.service.response

import java.util.Date

data class MovieDetails(
    val id: Int = 1,
    val name: String = "",
    val posterPath: String = "",
    val voteAverage: Double = 0.0,
    val releaseDate: Date = Date(),
)
