package com.example.appdesignmaterial.data

import android.app.Application
import android.content.Context
import com.example.appdesignmaterial.data.retrofit.NasaPictureOfTheDayApi
import com.example.appdesignmaterial.data.retrofit.NasaPictureOfTheDayRepoImpl
import com.example.appdesignmaterial.domain.repos.NasaPictureOfTheDayRepo
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val RETROFIT_BASE_URL = "https://api.nasa.gov/"

class App : Application() {

    private val retrofit = Retrofit.Builder()
        .baseUrl(RETROFIT_BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private var api: NasaPictureOfTheDayApi = retrofit.create(NasaPictureOfTheDayApi::class.java)

    val nasaPictureOfTheDayRepo: NasaPictureOfTheDayRepo by lazy { NasaPictureOfTheDayRepoImpl(api) }
}

val Context.app: App
    get() = applicationContext as App