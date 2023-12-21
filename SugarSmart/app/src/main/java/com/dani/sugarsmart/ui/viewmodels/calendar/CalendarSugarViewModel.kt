package com.dani.sugarsmart.ui.viewmodels.calendar

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dani.sugarsmart.data.sugar.dao.SugarEntryDAO
import com.dani.sugarsmart.data.sugar.dto.SugarEntryDTO
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CalendarSugarViewModel @Inject constructor(
    val sugarEntryDAO: SugarEntryDAO
) : ViewModel() {
    var sugarList = mutableStateListOf<SugarEntryDTO?>(null)

    init {
        getSugar()
    }

    private fun getSugar() {
        viewModelScope.launch {
            sugarList.addAll(sugarEntryDAO.readSugarEntries())
        }
    }
}
