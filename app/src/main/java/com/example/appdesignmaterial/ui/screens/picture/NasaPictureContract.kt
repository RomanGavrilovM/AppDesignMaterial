package com.example.appdesignmaterial.ui.screens.picture

import androidx.lifecycle.LiveData
import com.example.appdesignmaterial.domain.entities.NasaPictureEntity

class NasaPictureContract {

    interface ViewModel{
        val nasaPictureLiveData: LiveData<NasaPictureEntity>

        fun getData()
    }
}