package com.dani.sugarsmart.ui.viewmodels.ediit

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dani.sugarsmart.data.medicine.dao.MedicineInfoEntryDAO
import com.dani.sugarsmart.data.medicine.dto.MedicineInfoEntryDTO
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.time.LocalDateTime
import javax.inject.Inject

@HiltViewModel
class EditInfoAboutMedicineViewModel @Inject constructor(val medicineInfoEntryDAO: MedicineInfoEntryDAO) :
    ViewModel() {
    var medicineNameTextField by mutableStateOf("")
    var medicineDozeTextField by mutableStateOf("")
    var medicineDateTime by mutableStateOf(LocalDateTime.now())

    var insulinNameTextField by mutableStateOf("")
    var insulinDozeTextField by mutableStateOf("")
    var insulinDateTime by mutableStateOf(LocalDateTime.now())

    fun setMedicineName(value: String) {
        medicineNameTextField = value
    }

    fun setMedicineDoze(value: String) {
        medicineDozeTextField = value
    }

    fun setInsulinName(value: String) {
        insulinNameTextField = value
    }

    fun setInsulinDoze(value: String) {
        insulinDozeTextField = value
    }

    fun setMedicineDateTimeDateTime(value: LocalDateTime) {
        medicineDateTime = value
    }

    fun setInsulinDateTimeDateTime(value: LocalDateTime) {
        insulinDateTime = value
    }

    fun saveMedicineInfoEntry() {
        viewModelScope.launch {
            val medicineInfoEntry = MedicineInfoEntryDTO(
                id = null,
                medicineTime = medicineDateTime,
                medicineName = medicineNameTextField,
                medicineDose = medicineDozeTextField.toDouble(),
                insulinTime = insulinDateTime,
                insulinName = insulinNameTextField,
                insulinDose = insulinDozeTextField.toDouble(),
            )
            medicineInfoEntryDAO.insertMedicineInfoEntry(medicineInfoEntry)
        }
    }
}