package com.example.themoviedb.data.api

import com.example.themoviedb.common.Constants.BASE_URL
import com.example.themoviedb.common.Constants.TOKEN
import com.example.themoviedb.data.api.models.moviecategories.NowPlayingResponse
import com.example.themoviedb.data.api.models.moviecategories.PopularMovieResponse
import com.example.themoviedb.data.api.models.moviecategories.TopRatedResponse
import com.example.themoviedb.data.api.models.moviecategories.UpcomingResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.bearerAuth
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse
import io.ktor.http.append
import io.ktor.http.headers

class ApiService(private val client: HttpClient) {
    suspend fun getPopular(): HttpResponse {
       return client.get("$BASE_URL/popular") {
           bearerAuth(TOKEN)
        }
    }
    suspend fun getNowPlaying(): HttpResponse {
       return client.get("$BASE_URL/now_playing") {
            bearerAuth(TOKEN)
        }
    }
    suspend fun getUpcoming(): HttpResponse {
       return client.get("$BASE_URL/upcoming") {
           bearerAuth(TOKEN)
        }
    }
    suspend fun getTopRated(): HttpResponse {
       return client.get("$BASE_URL/top_rated") {
           bearerAuth(TOKEN)
        }
    }

}