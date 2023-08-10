package com.example.moviereview.ui.presentation.home.tabs

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.moviereview.ui.presentation.navigation.NavigationBarScreen
import com.example.moviereview.ui.presentation.search.SearchScreen

fun NavGraphBuilder.searchScreen() {
    composable(NavigationBarScreen.SearchScreen.route) {
        SearchScreen()
    }
}

@Composable
fun TvShowScreen() {
    Text(text = "TV Show", textAlign = TextAlign.Center)
}