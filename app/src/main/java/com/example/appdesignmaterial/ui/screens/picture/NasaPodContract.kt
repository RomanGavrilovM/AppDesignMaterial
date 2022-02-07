package com.example.appdesignmaterial.ui.screens.picture

import androidx.lifecycle.LiveData
import com.example.appdesignmaterial.domain.entities.NasaPodEntity

class NasaPodContract {

    interface ViewModel{
        val nasaPodLiveData: LiveData<NasaPodEntity>

        fun getData()
    }
}