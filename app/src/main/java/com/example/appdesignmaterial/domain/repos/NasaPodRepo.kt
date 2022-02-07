package com.example.appdesignmaterial.domain.repos

import com.example.appdesignmaterial.domain.entities.NasaPodEntity

interface NasaPodRepo {
    fun getPictureOfTheDay(
        onSuccess: (NasaPodEntity) -> Unit,
        onError: (Throwable) -> Unit
    )
}