package com.dani.sugarsmart.ui.viewmodels.calendar

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dani.sugarsmart.data.medicine.dao.MedicineInfoEntryDAO
import com.dani.sugarsmart.data.medicine.dto.MedicineInfoEntryDTO
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CalendarMedicineInfoViewModel @Inject constructor(
    val medicineInfoEntryDAO: MedicineInfoEntryDAO
) : ViewModel() {
    var medicineInfoList = mutableStateListOf<MedicineInfoEntryDTO?>(null)

    init {
        getMedicineInfo()
    }

    private fun getMedicineInfo() {
        viewModelScope.launch {
            medicineInfoList.addAll(medicineInfoEntryDAO.readMedicineInfoEntries())
        }
    }
}