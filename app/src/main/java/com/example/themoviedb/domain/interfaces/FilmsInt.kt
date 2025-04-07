package com.example.themoviedb.domain.interfaces

import com.example.themoviedb.data.api.models.moviecategories.NowPlayingResponse
import com.example.themoviedb.data.api.models.moviecategories.PopularMovieResponse
import com.example.themoviedb.data.api.models.moviecategories.TopRatedResponse
import com.example.themoviedb.data.api.models.moviecategories.UpcomingResponse

interface FilmsInt {
    suspend fun getPopular(): PopularMovieResponse?
    suspend fun getNowPlaying(): NowPlayingResponse?
    suspend fun getTopRated(): TopRatedResponse?
    suspend fun getUpcoming(): UpcomingResponse?
}