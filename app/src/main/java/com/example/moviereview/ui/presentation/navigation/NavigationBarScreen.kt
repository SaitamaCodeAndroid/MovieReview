package com.example.moviereview.ui.presentation.navigation

import androidx.annotation.DrawableRes
import com.example.moviereview.R

sealed class NavigationBarScreen(
    @DrawableRes val iconResource: Int,
    val label: String,
    val route: String,
) {
    data object HomeScreen : NavigationBarScreen(
        iconResource = R.drawable.ic_home,
        label = "Home",
        route = "home_screen",
    )

    data object SearchScreen : NavigationBarScreen(
        iconResource = R.drawable.ic_search,
        label = "Search",
        route = "search_screen",
    )

    data object CategoryScreen : NavigationBarScreen(
        iconResource = R.drawable.ic_category,
        label = "Genre",
        route = "genre_screen",
    )

    data object ProfileScreen : NavigationBarScreen(
        iconResource = R.drawable.ic_profile,
        label = "Profile",
        route = "profile_screen",
    )
}
