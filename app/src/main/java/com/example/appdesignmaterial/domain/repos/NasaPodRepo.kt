package com.example.appdesignmaterial.domain.repos

import com.example.appdesignmaterial.domain.entities.NasaPodEntity

interface NasaPodRepo {
    fun getPictureOfTheDaySync(): NasaPodEntity

    fun getPictureOfTheDayAsync(
        onSuccess: (NasaPodEntity) -> Unit,
        onError: (Throwable) -> Unit
    )
}