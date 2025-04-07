package com.example.themoviedb.data.api.models.moviecategories

import com.example.themoviedb.data.api.models.common.Dates
import com.example.themoviedb.data.api.models.common.Movie
import kotlinx.serialization.Serializable

@Serializable
data class PopularMovieResponse(
    val page: Int,
    val results: List<Movie>,
    val total_pages: Int,
    val total_results: Int
)

