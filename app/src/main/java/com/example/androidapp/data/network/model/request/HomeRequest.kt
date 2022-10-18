package com.example.androidapp.data.network.model.request

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class HomeRequest(
    val candidateEmail: String,
    val gender: String,
    val dob: String,
    val email: String
)
