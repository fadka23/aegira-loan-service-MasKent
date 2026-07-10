package com.blas.creditappdemo.data.model

import com.google.gson.annotations.SerializedName

data class KreditResponse(
    @SerializedName("status") val status: String,
    @SerializedName("message") val message: String,
    @SerializedName("data") val data: Any? = null
)