package com.example.appdesignmaterial.domain.repos

import com.example.appdesignmaterial.domain.entities.NasaPictureEntity

interface NasaPictureOfTheDayRepo {
    fun getPictureOfTheDay(
        onSuccess: (NasaPictureEntity) -> Unit,
        onError: (Throwable) -> Unit
    )
}