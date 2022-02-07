package com.example.appdesignmaterial.data.retrofit

import com.example.appdesignmaterial.BuildConfig
import com.example.appdesignmaterial.domain.entities.NasaPictureEntity
import com.example.appdesignmaterial.domain.repos.NasaPictureOfTheDayRepo
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class NasaPictureOfTheDayRepoImpl(private val api: NasaPictureOfTheDayApi) :
    NasaPictureOfTheDayRepo {

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