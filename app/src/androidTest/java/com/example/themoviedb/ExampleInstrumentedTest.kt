package com.example.themoviedb

import android.util.Log
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.themoviedb.common.Constants.BASE_URL
import com.example.themoviedb.common.Constants.TOKEN
import com.example.themoviedb.data.sharedPrefs.OnBoardingScreenInfo
import com.example.themoviedb.data.sharedPrefs.SharedPrefs
import com.example.themoviedb.domain.usecases.ShowOnBoardingUseCase
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.bearerAuth
import io.ktor.client.request.header
import io.ktor.client.request.headers
import io.ktor.client.request.post
import io.ktor.http.append
import io.ktor.http.isSuccess
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun testPrefsQueue() {
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext

        val sharedPrefs = SharedPrefs(appContext)
        val showOnBoardingUseCase = ShowOnBoardingUseCase(sharedPrefs)

        val firstItem = OnBoardingScreenInfo(
            image = R.drawable.ic_launcher_background,
            mainText = "Some text 1",
            descriptionText = "Big text 1"
        )
        val secondItem = OnBoardingScreenInfo(
            image = R.drawable.ic_launcher_background,
            mainText = "Some text 2",
            descriptionText = "Big text 2"
        )
        val thirdItem = OnBoardingScreenInfo(
            image = R.drawable.ic_launcher_background,
            mainText = "Some text 3",
            descriptionText = "Big text 3"
        )

        sharedPrefs.onBoardingQueue = listOf(firstItem, secondItem, thirdItem)
        assertEquals(showOnBoardingUseCase.execute(), firstItem)
        assertEquals(showOnBoardingUseCase.execute(), secondItem)
        assertEquals(showOnBoardingUseCase.execute(), thirdItem)
    }


}