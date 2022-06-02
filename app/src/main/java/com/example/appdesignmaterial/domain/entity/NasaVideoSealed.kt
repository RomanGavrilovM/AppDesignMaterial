package com.example.appdesignmaterial.domain.entity

sealed class NasaVideoSealed {
    data class Success(val serverResponseData: NASAVideo) : NasaVideoSealed()

    data class Error(val error: Throwable) : NasaVideoSealed()

    data class Loading(val progress: Int?) :NasaVideoSealed()
}
