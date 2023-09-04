package com.example.moviereview.ui.presentation.home.tabs

import androidx.compose.runtime.Composable
import com.example.moviereview.ui.presentation.home.model.MovieCollection

sealed class HomeTabScreen(
    val title: String,
    val screen: @Composable (
        movieListState: List<MovieCollection>
    ) -> Unit,
) {
    data object Movie : HomeTabScreen(
        title = "Movie",
        screen = { state ->
            MovieScreen(
                movieListState = state,
            )
        },
    )

    data object TvShow : HomeTabScreen(
        title = "TV Show",
        screen = { state ->
            TvShowScreen(
                movieListState = state
            )
        },
    )
}

val homeTabScreens = listOf(HomeTabScreen.Movie, HomeTabScreen.TvShow)
