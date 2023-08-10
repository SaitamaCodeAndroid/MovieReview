package com.example.moviereview.di

import com.example.moviereview.BuildConfig
import com.example.moviereview.data.MovieApiService
import com.example.moviereview.ui.presentation.home.HomeRepository
import com.example.moviereview.ui.presentation.home.HomeViewModel
import okhttp3.OkHttpClient
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

val appModule = module {

    single<MovieApiService> {
        val okHttpClient = OkHttpClient.Builder()
        Retrofit.Builder()
            .client(okHttpClient.build())
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create()
    }

    single {
        HomeRepository(get())
    }

    viewModelOf(::HomeViewModel)
}
