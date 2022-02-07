package com.example.appdesignmaterial.data

import android.app.Application
import android.content.Context
import com.example.appdesignmaterial.data.retrofit.NasaPodApi
import com.example.appdesignmaterial.data.retrofit.RetrofitNasaPodRepoImpl
import com.example.appdesignmaterial.domain.repos.NasaPodRepo
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val NASA_BASE_URL = "https://api.nasa.gov/"

class App : Application() {

    private val retrofit = Retrofit.Builder()
        .baseUrl(NASA_BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private var api: NasaPodApi = retrofit.create(NasaPodApi::class.java)

    val nasaPodRepo: NasaPodRepo by lazy { RetrofitNasaPodRepoImpl(api) }
}

val Context.app: App
    get() = applicationContext as App