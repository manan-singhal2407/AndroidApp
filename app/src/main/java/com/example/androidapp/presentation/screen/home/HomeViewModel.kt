package com.example.androidapp.presentation.screen.home

import android.app.DatePickerDialog
import android.content.Context
import android.widget.DatePicker
import android.widget.Toast
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import java.util.Calendar
import java.util.Date

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val homeRepository: HomeRepository
) : ViewModel() {
    var date = mutableStateOf("")
    val genderOptions = listOf("Male", "Female", "Others")
    var selectedOption = mutableStateOf(genderOptions[0])
    var email = mutableStateOf("")

    val savingData = mutableStateOf(false)

    fun showDateDialog(context: Context) {
        val mYear: Int
        val mMonth: Int
        val mDay: Int
        val mCalendar = Calendar.getInstance()
        mYear = mCalendar.get(Calendar.YEAR)
        mMonth = mCalendar.get(Calendar.MONTH)
        mDay = mCalendar.get(Calendar.DAY_OF_MONTH)
        mCalendar.time = Date()
        val mDatePickerDialog = DatePickerDialog(
            context,
            { _: DatePicker, year: Int, month: Int, dayOfMonth: Int ->
                date.value = "$dayOfMonth/${month + 1}/$year"
            }, mYear, mMonth, mDay
        )
        mDatePickerDialog.show()
    }

    fun saveUserData(context: Context) {
        if (date.value.isEmpty() || email.value.isEmpty()) {
            Toast.makeText(context, "Incomplete details", Toast.LENGTH_SHORT).show()
            return
        }
        savingData.value = true
        homeRepository.saveUserData(CANDIDATE_EMAIL, selectedOption.value, date.value, email.value)
            .onEach { dataState ->
                dataState.data?.let { response ->
                    savingData.value = false
                    Toast.makeText(
                        context,
                        "API successfully called with return type ${response.success}",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                dataState.error?.let { message ->
                    savingData.value = false
                    Toast.makeText(context, "API failed: $message", Toast.LENGTH_SHORT).show()
                }
            }.launchIn(viewModelScope)
    }

    companion object {
        const val CANDIDATE_EMAIL = "2019csb1099@iitrpr.ac.in"
    }
}