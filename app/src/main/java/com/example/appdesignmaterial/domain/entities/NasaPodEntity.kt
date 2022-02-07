package com.example.appdesignmaterial.domain.entities

import com.google.gson.annotations.SerializedName

data class NasaPodEntity(
    @SerializedName("url")
    val url: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("explanation")
    val description: String,
    @SerializedName("date")
    val date: String,
    @SerializedName("copyright")
    val copyright: String
)