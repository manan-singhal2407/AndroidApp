package com.example.androidapp.presentation.screen.home

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val homeRepository: HomeRepository
) : ViewModel() {
    val loading = mutableStateOf(false)
    val errorMessage = mutableStateOf("")

    fun saveUserData(code: String) {
        homeRepository.saveUserData(CANDIDATE_EMAIL, code, code, code).onEach { dataState ->
            loading.value = dataState.loading
            dataState.data?.let { response ->
//                logVerificationCompleted(response)
//                appSettings.writeToken(response.accessToken, response.refreshToken)
//                navigator.popAndNavigate(Screen.Login, Screen.CommunityList)
            }
            dataState.error?.let { message ->
//                logVerificationFailed(message)
//                errorMessage.value = message
            }
        }.launchIn(viewModelScope)
    }

    companion object {
        const val CANDIDATE_EMAIL = "2019csb1099@iitrpr.ac.in"
    }
}