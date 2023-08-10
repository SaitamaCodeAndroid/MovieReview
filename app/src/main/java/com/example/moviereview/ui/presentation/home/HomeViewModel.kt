package com.example.moviereview.ui.presentation.home

import androidx.lifecycle.ViewModel

class HomeViewModel (
    private val homeRepository: HomeRepository
): ViewModel() {
    val movies = homeRepository
        .getMovies()
        .flow
}