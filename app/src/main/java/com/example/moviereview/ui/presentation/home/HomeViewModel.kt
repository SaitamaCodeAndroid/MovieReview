package com.example.moviereview.ui.presentation.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviereview.domain.home.MovieInteractor
import com.example.moviereview.ui.presentation.home.model.MovieCollection
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class HomeViewModel(
    private val movieInteractor: MovieInteractor,
) : ViewModel() {

    internal var isRefreshing by mutableStateOf(false)
    internal var movieListState by mutableStateOf<List<MovieCollection>>(emptyList())
    internal var tvShowsListState by mutableStateOf<List<MovieCollection>>(emptyList())

    init {
        loadMovies()
        loadTvShows()
    }

    fun loadTvShows() {
        viewModelScope.launch {
            movieInteractor.getTvShowCollections().collectLatest { movies ->
                isRefreshing = false
                tvShowsListState = movies
            }
        }
    }

    fun loadMovies() {
        viewModelScope.launch {
            movieInteractor.getMovieCollections().collectLatest { movies ->
                isRefreshing = false
                movieListState = movies
            }
        }
    }

    fun reloadMovies() {
        isRefreshing = true
        loadMovies()
    }

    fun reloadTvShows() {
        isRefreshing = true
        loadTvShows()
    }
}
