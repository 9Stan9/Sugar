package com.dani.sugarsmart.ui.viewmodels.ediit

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dani.sugarsmart.data.calories.dao.CalorieEntryDAO
import com.dani.sugarsmart.data.calories.dto.CalorieEntryDTO
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.time.LocalDateTime
import javax.inject.Inject

@HiltViewModel
class EditCaloriesViewModel @Inject constructor(val calorieEntryDAO: CalorieEntryDAO) :
    ViewModel() {
    var caloriesTextField by mutableStateOf("")
    var nameTextField by mutableStateOf("")
    var dateTime by mutableStateOf(LocalDateTime.now())

    fun setCalories(value: String) {
        caloriesTextField = value
    }

    fun setDate(value: LocalDateTime) {
        dateTime = value
    }

    fun saveCaloriesEntry() {
        viewModelScope.launch {
            val calorieEntry = CalorieEntryDTO(
                id = null,
                time = dateTime,
                caloriesConsumed = caloriesTextField.toDouble()
            )
            calorieEntryDAO.insertCalorieEntry(calorieEntry)
        }
    }
}