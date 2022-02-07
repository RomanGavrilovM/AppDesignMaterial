package com.example.appdesignmaterial.ui.screens.picture

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.appdesignmaterial.domain.entities.NasaPictureEntity
import com.example.appdesignmaterial.domain.repos.NasaPictureOfTheDayRepo

class NasaPictureViewModel(private val nasaPictureOfTheDayRepo: NasaPictureOfTheDayRepo) :
    ViewModel(), NasaPictureContract.ViewModel {

    override val nasaPictureLiveData = MutableLiveData<NasaPictureEntity>()

    override fun getData() {
        nasaPictureOfTheDayRepo.getPictureOfTheDay(
            onSuccess = { nasaPictureEntity ->
                nasaPictureLiveData.postValue(nasaPictureEntity)
            },
            onError = { error ->
                Log.d("@@@", error.message.toString())
            }
        )
    }
}