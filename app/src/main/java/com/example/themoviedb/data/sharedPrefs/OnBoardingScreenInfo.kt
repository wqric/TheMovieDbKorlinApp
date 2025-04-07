package com.example.themoviedb.data.sharedPrefs

import androidx.annotation.DrawableRes

data class OnBoardingScreenInfo(
    @DrawableRes val image: Int,
    val mainText: String,
    val descriptionText: String
)