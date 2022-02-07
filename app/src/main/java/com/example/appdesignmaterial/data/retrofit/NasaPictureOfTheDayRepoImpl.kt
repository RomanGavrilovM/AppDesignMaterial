package com.example.appdesignmaterial.data.retrofit

import com.example.appdesignmaterial.BuildConfig
import com.example.appdesignmaterial.domain.entities.NasaPictureEntity
import com.example.appdesignmaterial.domain.repos.NasaPictureOfTheDayRepo
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.IllegalStateException

private const val BASE_URL = "https://api.nasa.gov/"

class NasaPictureOfTheDayRepoImpl : NasaPictureOfTheDayRepo {

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private var api: NasaPictureOfTheDayApi = retrofit.create(NasaPictureOfTheDayApi::class.java)

    override fun getPictureOfTheDay(
        onSuccess: (NasaPictureEntity) -> Unit,
        onError: (Throwable) -> Unit
    ) {
        val apiKey = BuildConfig.NASA_API_KEY
        api.getPictureOfTheDay(apiKey).enqueue(object : Callback<NasaPictureEntity> {
            override fun onResponse(
                call: Call<NasaPictureEntity>,
                response: Response<NasaPictureEntity>
            ) {
                if (response.isSuccessful) {
                    onSuccess(response.body() ?: throw IllegalStateException("null result"))
                } else {
                    onError(Throwable("unknown error"))
                }
            }

            override fun onFailure(call: Call<NasaPictureEntity>, t: Throwable) {
                onError(t)
            }
        })
    }
}