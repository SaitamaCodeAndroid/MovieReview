package com.example.moviereview.ui.presentation.home.tabs

import androidx.compose.runtime.Composable

sealed class HomeTabScreen(
    val title: String,
    val screen: @Composable () -> Unit,
) {
    data object Movie : HomeTabScreen(
        title = "Movie",
        screen = { MovieScreen() },
    )

    data object TvShow : HomeTabScreen(
        title = "TV Show",
        screen = { TvShowScreen() },
    )
}

val homeTabScreens = listOf(HomeTabScreen.Movie, HomeTabScreen.TvShow)
