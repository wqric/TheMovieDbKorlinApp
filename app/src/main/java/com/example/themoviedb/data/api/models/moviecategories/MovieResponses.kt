package com.example.themoviedb.data.api.models.moviecategories

import com.example.themoviedb.data.api.models.common.Movie

data class MovieResponses(
    val popularMovieResponse: List<Movie>,
    val nowPlayingResponse: List<Movie>,
    val upcomingResponse: List<Movie>,
    val topRatedResponse: List<Movie>
)