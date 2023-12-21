package com.dani.sugarsmart.ui.viewmodels.ediit

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dani.sugarsmart.data.physical.dao.PhysicalActivityEntryDAO
import com.dani.sugarsmart.data.physical.dto.PhysicalActivityEntryDTO
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import kotlinx.datetime.toKotlinLocalTime
import java.time.LocalDateTime
import java.time.LocalTime
import javax.inject.Inject

@HiltViewModel
class EditPhysicalViewModel @Inject constructor(val physicalActivityEntryDAO: PhysicalActivityEntryDAO) :
    ViewModel() {
    var distanceTextField by mutableStateOf("")
    var pulseTextField by mutableStateOf("")
    var caloriesTextField by mutableStateOf("")
    var dateTime by mutableStateOf(LocalDateTime.now())
    var activityTime by mutableStateOf("")
    var activityType by mutableStateOf("")
    var intensiveType by mutableStateOf("")

    fun setDistance(value: String) {
        distanceTextField = value
    }

    fun setPulse(value: String) {
        pulseTextField = value
    }

    fun setCalories(value: String) {
        caloriesTextField = value
    }

    fun setDate(value: LocalDateTime) {
        dateTime = value
    }

    fun setActivityTime(value: LocalTime) {
        activityTime = value.toString()
    }

    fun savePhysicalActivityEntry() {
        viewModelScope.launch {
            val physicalActivityEntry = PhysicalActivityEntryDTO(
                id = null,
                time = dateTime,
                activityType = activityType,
                duration = activityTime,
                intensive = intensiveType,
                distance = distanceTextField.toDouble(),
                pulse = pulseTextField.toInt(),
                caloriesBurned = caloriesTextField.toDouble()
            )
            physicalActivityEntryDAO.insertPhysicalActivityEntry(physicalActivityEntry)
        }
    }
}