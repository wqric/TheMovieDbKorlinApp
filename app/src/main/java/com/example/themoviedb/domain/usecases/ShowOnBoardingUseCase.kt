package com.example.themoviedb.domain.usecases

import android.util.Log
import com.example.themoviedb.data.sharedPrefs.OnBoardingScreenInfo
import com.example.themoviedb.data.sharedPrefs.SharedPrefs

class ShowOnBoardingUseCase(private val sharedPrefs: SharedPrefs) {
    fun execute(): OnBoardingScreenInfo {
        val onBoardingList = sharedPrefs.onBoardingQueue
        Log.d("useCase", onBoardingList.toString())
        val item = onBoardingList[0]
        sharedPrefs.onBoardingQueue = onBoardingList.drop(1)
        return item
    }
}