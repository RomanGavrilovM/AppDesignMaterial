package com.example.appdesignmaterial.ui.screens.picture

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.appdesignmaterial.domain.repos.NasaPictureOfTheDayRepo

class NasaPictureViewModelFactory(private val nasaPictureOfTheDayRepo: NasaPictureOfTheDayRepo):
    ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return NasaPictureViewModel(nasaPictureOfTheDayRepo) as T
    }
}