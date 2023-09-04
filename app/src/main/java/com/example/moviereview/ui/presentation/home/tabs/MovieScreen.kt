package com.example.moviereview.ui.presentation.home.tabs

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.moviereview.ui.presentation.home.model.MovieCollection
import com.example.moviereview.ui.presentation.home.model.MovieType

@Composable
fun MovieScreen(
    movieListState: List<MovieCollection>,
) {
    val scrollState = rememberScrollState()

    Column(modifier = Modifier.verticalScroll(scrollState)) {
        movieListState.forEach { movieCollection ->
            when (movieCollection.type) {
                MovieType.Upcoming -> TopUpMovieSection(movieCollection.movies)
                else -> {
                    MovieCollectionSection(
                        collectionName = movieCollection.type.typeName,
                        movies = movieCollection.movies
                    )
                }
            }
        }
    }
}
