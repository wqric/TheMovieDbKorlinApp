package com.example.themoviedb.domain.usecases

import android.util.Log
import com.example.themoviedb.data.api.models.moviecategories.MovieResponses
import com.example.themoviedb.data.repositories.FilmsRep

class MoviesUseCase(private val filmsRep: FilmsRep) {
    suspend fun execute(): MovieResponses {
        val res1 = filmsRep.getPopular()?.results?: emptyList()
        val res2 = filmsRep.getUpcoming()?.results?: emptyList()
        val res3 = filmsRep.getTopRated()?.results?: emptyList()
        val res4 = filmsRep.getNowPlaying()?.results?: emptyList()
        val movieList = MovieResponses(popularMovieResponse = res1, upcomingResponse = res2, topRatedResponse = res3, nowPlayingResponse = res4)
        return MovieResponses(popularMovieResponse = res1, upcomingResponse = res2, topRatedResponse = res3, nowPlayingResponse = res4)
    }
}