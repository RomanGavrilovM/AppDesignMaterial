package com.example.appdesignmaterial.iu.iu.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.appdesignmaterial.iu.iu.adapter.UniverseScreen
import com.example.appdesignmaterial.iu.iu.universescreen.DailyUniverseScreen
import com.example.appdesignmaterial.iu.iu.universescreen.EarthUniverseScreen
import com.example.appdesignmaterial.iu.iu.universescreen.NasaVideoUniverseScreen

class UniverseViewModel(
    private val liveDataForViewToObserve: MutableLiveData<List <UniverseScreen>> = MutableLiveData()
) : ViewModel() {
    fun getFragmentUniverse(): LiveData<List <UniverseScreen>> {

        liveDataForViewToObserve.value =
            listOf(
                DailyUniverseScreen()
                ,EarthUniverseScreen()
                ,NasaVideoUniverseScreen()
            )
        return liveDataForViewToObserve
    }
}
