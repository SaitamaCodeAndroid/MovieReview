package com.example.moviereview.data.service.response

import com.google.gson.annotations.SerializedName
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

data class MovieResponse(
    @SerializedName("results")
    val movies: List<Movie>
) {

    fun fromMovieToMovieDetailsList(locale: Locale = Locale.getDefault()): List<MovieDetails> {
        return this.movies.map { movie ->
            movie.toMovieDetailsModel(locale)
        }
    }
}

data class Movie(
    val id: Int,
    @SerializedName("poster_path")
    val posterPath: String,
    @SerializedName("release_date")
    val releaseDate: String = "",
    val title: String,
    @SerializedName("vote_average")
    val voteAverage: Double,
) {

    fun toMovieDetailsModel(locale: Locale) = MovieDetails(
        id = this.id,
        posterPath = this.posterPath,
        name = this.title,
        voteAverage = this.voteAverage,
        /*releaseDate = SimpleDateFormat("MMM dd", locale).parse(
            if (releaseDate.isNotEmpty()) {
                this.releaseDate
            } else {
                Date().toString()
            }
        ) as Date*/
    )
}
