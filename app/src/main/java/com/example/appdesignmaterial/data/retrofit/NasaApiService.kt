package com.example.appdesignmaterial.data.retrofit

import retrofit2.Call
import retrofit2.http.*
import com.example.appdesignmaterial.domain.entity.NASAImageResponse

interface NasaApiService {
    @GET("planetary/apod")
    fun getImage(@Query("api_key") apiKey: String): Call<NASAImageResponse>
}