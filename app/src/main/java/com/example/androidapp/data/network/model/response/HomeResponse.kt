package com.example.androidapp.data.network.model.response

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class HomeResponse(
    val success: Boolean
)
