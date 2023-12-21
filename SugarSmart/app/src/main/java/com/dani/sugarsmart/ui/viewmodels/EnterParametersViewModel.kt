package com.dani.sugarsmart.ui.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class EnterParametersViewModel @Inject constructor() : ViewModel() {
    var heightTextField by mutableStateOf("")
    var weightTextField by mutableStateOf("")
    var ageTextField by mutableStateOf("")
    val genderPicker = listOf("М", "Ж")
    val diabetesTypePicker = listOf("1 тип","2 тип")

    fun setHeight(value: String) {
        heightTextField = value
    }

    fun setWeight(value: String) {
        weightTextField = value
    }

    fun setAge(value: String) {
        ageTextField = value
    }

    fun setGenderPicker(value: String) {
    }
}