package com.example.appdesignmaterial.domain.repos

import com.example.appdesignmaterial.domain.entities.NasaPodEntity

interface NasaPictureOfTheDayRepo {
    fun getPictureOfTheDay(
        onSuccess: (NasaPodEntity) -> Unit,
        onError: (Throwable) -> Unit
    )
}