package com.example.appdesignmaterial.data.retrofit

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import com.example.appdesignmaterial.domain.entity.NASAImageEarth
import com.example.appdesignmaterial.domain.entity.NASAImageResponse
import com.example.appdesignmaterial.domain.entity.NASAVideo

interface NasaApiService {

    @GET("planetary/apod")
    fun getImage(@Query("api_key") apiKey: String): Call<NASAImageResponse>

    @GET("planetary/earth/assets?lon=100.75&lat=1.5&date=2014-02-01&dim=0.15&")
    fun getImageEarth(@Query("api_key") apiKey: String): Call<NASAImageEarth>

    @GET("planetary/apod?date=2015-06-01&concept_tags=True&")
    fun getVideo(@Query("api_key") apiKey: String): Call<NASAVideo>
}