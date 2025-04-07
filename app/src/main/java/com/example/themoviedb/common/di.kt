package com.example.themoviedb.common

import com.example.themoviedb.data.api.ApiService
import com.example.themoviedb.data.repositories.FilmsRep
import com.example.themoviedb.domain.usecases.MoviesUseCase
import com.example.themoviedb.presentation.viewmodels.MainViewModel
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    viewModel<MainViewModel> {
        MainViewModel(get())
    }

    single<HttpClient> {
        return@single HttpClient(CIO) {
            install(ContentNegotiation) {
                json(Json {
                    ignoreUnknownKeys = true
                    prettyPrint = true
                })
            }
        }
    }

    single<ApiService> {
        return@single ApiService(get())
    }

    single<FilmsRep> {
        return@single FilmsRep(get())
    }

    single<MoviesUseCase> {
        return@single MoviesUseCase(get())
    }

}