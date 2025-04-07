package com.example.themoviedb.presentation.viewmodels

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.themoviedb.data.api.models.common.Movie
import com.example.themoviedb.domain.usecases.MoviesUseCase
import kotlinx.coroutines.launch

class MainViewModel(private val moviesUseCase: MoviesUseCase): ViewModel() {
    val popularMoviesState = mutableStateOf<List<Movie>>(emptyList())
    val topRatedState = mutableStateOf<List<Movie>>(emptyList())
    val upcomingState = mutableStateOf<List<Movie>>(emptyList())
    val nowPlayingState = mutableStateOf<List<Movie>>(emptyList())
    fun getMovies() {
        viewModelScope.launch {
            launch {
                try {
                    val res = moviesUseCase.execute()
                    popularMoviesState.value = res.popularMovieResponse
                    topRatedState.value = res.topRatedResponse
                    upcomingState.value = res.upcomingResponse
                    nowPlayingState.value = res.nowPlayingResponse
                    Log.d("films", res.toString())
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }

        }
    }
}