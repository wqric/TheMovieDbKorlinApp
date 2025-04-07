package com.example.themoviedb.data.sharedPrefs

import android.content.Context
import android.util.Log
import androidx.core.content.edit

class SharedPrefs(context: Context) {

    companion object {
        private const val SHARED_PREFS_KEY = "MUVJANLDJNVJLKJANEIDJLHVMAKUEJDLHJVNL"
        private const val ON_BOARDING_KEY = "ON_BOARDING_STATE_KEY"
    }


    private val sharedPrefs = context.getSharedPreferences(SHARED_PREFS_KEY, Context.MODE_PRIVATE)

    var onBoardingQueue: List<OnBoardingScreenInfo>
        get() {
            val items = sharedPrefs.getString(ON_BOARDING_KEY, "")
            Log.d("SharedPrefs1", items.toString())
            val itemList = mutableListOf<OnBoardingScreenInfo>()
            for (item in items!!.split("|")) {
                itemList.add(
                    OnBoardingScreenInfo(
                        image = item.split("%")[0].toInt(),
                        mainText = item.split("%")[1],
                        descriptionText = item.split("%")[2]
                    )
                )

                Log.d("SharedPrefs1", itemList.toString())
            }
            return itemList
        }
        set(values) {
            Log.d("SharedPrefs", "start $values")
            val result = StringBuilder()
            for ((index, value) in values.withIndex()) {
                result.append("${value.image}%${value.mainText}%${value.descriptionText}")
                if (index != (values.size - 1)) {
                    result.append("|")
                }
            }
            sharedPrefs.edit { putString(ON_BOARDING_KEY, result.toString()) }
        }
}