package com.example.androidapp.data.network.service

import com.example.androidapp.data.network.model.request.HomeRequest
import com.example.androidapp.data.network.model.response.HomeResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface HomeService {
    @POST("kyc/emailGenderDob")
    suspend fun saveUserData(@Body homeRequest: HomeRequest): HomeResponse
}