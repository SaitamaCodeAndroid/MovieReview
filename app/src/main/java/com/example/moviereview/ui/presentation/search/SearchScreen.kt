package com.example.moviereview.ui.presentation.search

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.moviereview.ui.presentation.navigation.NavigationBarScreen

fun NavGraphBuilder.searchScreen() {
    composable(NavigationBarScreen.SearchScreen.route) {
        SearchScreen()
    }
}
@Composable
fun SearchScreen() {}