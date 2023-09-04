package com.example.moviereview.data.service.response

import com.google.gson.annotations.SerializedName
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

data class TvShowResponse(
    @SerializedName("results")
    val tvShows: List<TvShow>
) {

    fun fromTvShowToMovieDetailsList(locale: Locale = Locale.getDefault()): List<MovieDetails> {
        return this.tvShows.map { tvShows ->
            tvShows.toMovieDetailsModel(locale)
        }
    }
}

data class TvShow(
    val id: Int = 1,
    @SerializedName("first_air_date")
    val releaseDate: String = "",
    val name: String = "",
    @SerializedName("poster_path")
    val posterPath: String = "",
    @SerializedName("vote_average")
    val voteAverage: Double = 0.0,
) {

    fun toMovieDetailsModel(locale: Locale) = MovieDetails(
        id = this.id,
        posterPath = this.posterPath,
        name = this.name,
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
