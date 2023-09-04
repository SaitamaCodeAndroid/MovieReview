package com.example.moviereview.di

import com.example.moviereview.BuildConfig
import com.example.moviereview.data.datasource.ApiDataSource
import com.example.moviereview.data.repository.HomeRepository
import com.example.moviereview.data.service.MovieApiService
import com.example.moviereview.domain.home.MovieInteractor
import com.example.moviereview.ui.presentation.home.HomeViewModel
import okhttp3.OkHttpClient
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.singleOf
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

    singleOf(::ApiDataSource)

    singleOf(::HomeRepository)

    singleOf(::MovieInteractor)

    viewModelOf(::HomeViewModel)
}
