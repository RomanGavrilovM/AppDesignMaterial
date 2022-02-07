package com.example.appdesignmaterial.ui.screens.picture

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.appdesignmaterial.domain.entities.NasaPodEntity
import com.example.appdesignmaterial.domain.repos.NasaPodRepo

class NasaPodViewModel(private val nasaPodRepo: NasaPodRepo) :
    ViewModel(), NasaPodContract.ViewModel {

    override val nasaPodLiveData = MutableLiveData<NasaPodEntity>()

    override fun getData() {
        nasaPodRepo.getPictureOfTheDayAsync(
            onSuccess = { nasaPictureEntity ->
                nasaPodLiveData.postValue(nasaPictureEntity)
            },
            onError = { error ->
                Log.d("@@@", error.message.toString())
            }
        )
    }
}