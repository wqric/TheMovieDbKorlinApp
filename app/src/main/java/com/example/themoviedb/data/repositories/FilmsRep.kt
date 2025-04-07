package com.example.themoviedb.data.repositories

import android.util.Log
import com.example.themoviedb.data.api.ApiService
import com.example.themoviedb.data.api.models.moviecategories.NowPlayingResponse
import com.example.themoviedb.data.api.models.moviecategories.PopularMovieResponse
import com.example.themoviedb.data.api.models.moviecategories.TopRatedResponse
import com.example.themoviedb.data.api.models.moviecategories.UpcomingResponse
import com.example.themoviedb.domain.interfaces.FilmsInt
import io.ktor.client.call.body
import io.ktor.http.isSuccess

class FilmsRep(private val apiService: ApiService) : FilmsInt {
    override suspend fun getPopular(): PopularMovieResponse? {
        val response = apiService.getPopular()
        Log.d("films1", response.body())
        return if (response.status.isSuccess()) {
            response.body()
        }
        else null
    }

    override suspend fun getNowPlaying(): NowPlayingResponse? {
        val response = apiService.getNowPlaying()
        Log.d("films2", response.body())
        return if (response.status.isSuccess()) {
            response.body()
        }
        else null
    }

    override suspend fun getTopRated(): TopRatedResponse? {
        val response = apiService.getTopRated()
        Log.d("films3", response.body())
        return if (response.status.isSuccess()) {
            response.body()
        }
        else null
    }

    override suspend fun getUpcoming(): UpcomingResponse? {
        val response = apiService.getUpcoming()
        Log.d("films4", response.body())
        return if (response.status.isSuccess()) {
            response.body()
        }
        else null
    }

}