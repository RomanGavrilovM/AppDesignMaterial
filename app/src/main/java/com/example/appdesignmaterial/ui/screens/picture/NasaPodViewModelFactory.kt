package com.example.appdesignmaterial.ui.screens.picture

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.appdesignmaterial.domain.repos.NasaPodRepo

class NasaPodViewModelFactory(private val nasaPodRepo: NasaPodRepo):
    ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return NasaPodViewModel(nasaPodRepo) as T
    }
}