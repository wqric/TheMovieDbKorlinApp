package com.example.themoviedb.data.api.models.common

import kotlinx.serialization.Serializable

@Serializable
data class Dates(
    val maximum: String,
    val minimum: String
)