package com.example.themoviedb.presentation.viewmodels

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.themoviedb.common.Constants.BASE_URL
import com.example.themoviedb.common.Constants.TOKEN
import com.example.themoviedb.data.api.models.common.Movie
import com.example.themoviedb.domain.usecases.MoviesUseCase
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.ClientRequestException
import io.ktor.client.plugins.ServerResponseException
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.bearerAuth
import io.ktor.client.request.headers
import io.ktor.client.request.post
import io.ktor.http.HttpHeaders
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.launch
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

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
    fun testKtor() {
        val client = HttpClient(CIO) {
            install(ContentNegotiation) {
                json(Json {
                    ignoreUnknownKeys = true
                    prettyPrint = true
                })
            }
        }

        viewModelScope.launch {
            Log.d("ed", "start")
            val response = createNewToken(client)
            Log.d("ed", response.toString())
        }
    }
    suspend fun createNewToken(client: HttpClient): TokenResponse {
        return client.post("$BASE_URL/authentication/token/new") {
            // Добавляем заголовки
            headers {
                append(HttpHeaders.Accept, "application/json")
            }

            // Добавляем Bearer-аутентификацию
            bearerAuth(TOKEN)

            // Если нужно отправить тело запроса (опционально)
            // setBody(TokenRequest(someParam = "value"))
        }.body() // Десериализуем ответ в TokenResponse
    }

}

@Serializable
data class TokenResponse(
    val success: Boolean,
    val expires_at: String,
    val request_token: String
)