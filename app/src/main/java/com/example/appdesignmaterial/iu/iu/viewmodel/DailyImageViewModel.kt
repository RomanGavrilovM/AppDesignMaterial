package com.example.appdesignmaterial.iu.iu.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Response
import com.example.appdesignmaterial.BuildConfig
import com.example.appdesignmaterial.data.retrofit.NasaApiRetrofit
import com.example.appdesignmaterial.domain.entity.DailyImage
import com.example.appdesignmaterial.domain.entity.NASAImageEarth
import javax.security.auth.callback.Callback
import com.example.appdesignmaterial.domain.entity.NASAImageResponse as NASAImageResponse

class DailyImageViewModel(
    private val liveDataForViewToObserve:MutableLiveData<DailyImage> = MutableLiveData(),
    private val retrofitImpl: NasaApiRetrofit = NasaApiRetrofit()
):ViewModel() {

    fun getImageData():LiveData<DailyImage>{
        sendServerRequest()
        return liveDataForViewToObserve
    }

    private fun sendServerRequest(){
        liveDataForViewToObserve.value = DailyImage.Loading(null)
        val apiKey = BuildConfig.NASA_API_KEY
        if(apiKey.isBlank()){
            DailyImage.Error(Throwable("Нужен API ключ"))
        } else{
            executeImageRequest(apiKey)
        }
    }


    private fun executeImageRequest(apiKey:String){
        retrofitImpl.getNasaService().getImage(apiKey).enqueue(
            object : retrofit2.Callback<NASAImageResponse> {
                override fun onResponse(
                    call: Call<NASAImageResponse>,
                    response: Response<NASAImageResponse>
                ) {
                    handleImageResponse(response)
                }

                override fun onFailure(call: Call<NASAImageResponse>, t: Throwable) {
                    liveDataForViewToObserve.value =DailyImage.Error(t)
                }

            }
        )
    }
    private fun handleImageResponse(response: Response<NASAImageResponse>) {
        if (response.isSuccessful && response.body() != null) {
            liveDataForViewToObserve.value = DailyImage.Success(response.body()!!)
            return
        }

        val message = response.message()
        if (message.isNullOrEmpty()) {
            liveDataForViewToObserve.value = DailyImage.Error(Throwable("Unidentified error"))
        } else {
            liveDataForViewToObserve.value = DailyImage.Error(Throwable(message))
        }
    }



}