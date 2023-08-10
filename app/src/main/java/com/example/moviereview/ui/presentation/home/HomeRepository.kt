package com.example.moviereview.ui.presentation.home

import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.example.moviereview.data.MovieApiService
import com.example.moviereview.data.MoviePagingSource

class HomeRepository(
    private val movieApiService: MovieApiService
) {

    companion object {
        private const val PAGE_SIZE = 20
    }

    fun getMovies() = Pager(
        PagingConfig(
            pageSize = PAGE_SIZE,
            enablePlaceholders = true
        )
    ) {
        MoviePagingSource(service = movieApiService)
    }
}