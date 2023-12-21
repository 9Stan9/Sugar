package com.dani.sugarsmart.ui.viewmodels.calendar

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
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
class CalendarCaloriesViewModel @Inject constructor(val calorieEntryDAO: CalorieEntryDAO) :
    ViewModel() {
    var caloriesList = mutableStateListOf<CalorieEntryDTO?>(null)

    init {
        getCalories()
    }

    private fun getCalories() {
        viewModelScope.launch {
            caloriesList.addAll(calorieEntryDAO.readCalorieEntries())
        }
    }
}