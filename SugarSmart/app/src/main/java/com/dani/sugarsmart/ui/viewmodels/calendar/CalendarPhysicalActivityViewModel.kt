package com.dani.sugarsmart.ui.viewmodels.calendar

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dani.sugarsmart.data.physical.dao.PhysicalActivityEntryDAO
import com.dani.sugarsmart.data.physical.dto.PhysicalActivityEntryDTO
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CalendarPhysicalActivityViewModel @Inject constructor(
    val physicalActivityEntryDAO: PhysicalActivityEntryDAO
) : ViewModel() {
    var physicalActivityList = mutableStateListOf<PhysicalActivityEntryDTO?>(null)

    init {
        getPhysicalActivity()
    }

    private fun getPhysicalActivity() {
        viewModelScope.launch {
            physicalActivityList.addAll(physicalActivityEntryDAO.readPhysicalActivityEntries())
        }
    }
}