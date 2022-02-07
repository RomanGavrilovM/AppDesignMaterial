package com.example.appdesignmaterial.domain.entities

import com.google.gson.annotations.SerializedName

data class NasaPictureEntity(
    @SerializedName("url")
    val url: String,
    @SerializedName("explanation")
    val explanation: String
)