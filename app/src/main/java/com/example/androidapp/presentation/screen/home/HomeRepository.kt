package com.example.androidapp.presentation.screen.home

import com.example.androidapp.data.network.model.request.HomeRequest
import com.example.androidapp.data.network.model.response.HomeResponse
import com.example.androidapp.data.network.service.HomeService
import com.example.androidapp.domain.state.DataState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow

class HomeRepository(private val homeService: HomeService) {
    fun saveUserData(
        candidateEmail: String,
        gender: String,
        dob: String,
        email: String
    ): Flow<DataState<HomeResponse>> = flow {
        emit(DataState.success(homeService.saveUserData(HomeRequest(candidateEmail, gender, dob, email))))
    }.catch {
        emit(DataState.error(it.message ?: "Unknown Error"))
    }
}