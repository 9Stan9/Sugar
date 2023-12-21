package com.dani.sugarsmart.ui.viewmodels.ediit

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dani.sugarsmart.data.sugar.dao.SugarEntryDAO
import com.dani.sugarsmart.data.sugar.dto.SugarEntryDTO
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.time.LocalDateTime
import javax.inject.Inject

@HiltViewModel
class EditSugarViewModel @Inject constructor(val sugarEntryDAO: SugarEntryDAO) : ViewModel() {
    var sugarTextField by mutableStateOf("")
    var nameTextField by mutableStateOf("")
    var eatTime by mutableStateOf(LocalDateTime.now())
    var sugarTime by mutableStateOf(LocalDateTime.now())

    fun setSugar(value: String) {
        sugarTextField = value
    }

    fun setName(value: String) {
        nameTextField = value
    }

    fun setEatDateTime(value: LocalDateTime) {
        eatTime = value
    }

    fun setSugarDateTime(value: LocalDateTime) {
        sugarTime = value
    }

    fun saveSugarEntry() {
        viewModelScope.launch {
            val sugarEntry = SugarEntryDTO(
                id = null,
                time = sugarTime,
                sugarLevel = sugarTextField.toDouble(),
                eatName = nameTextField,
                eatTime = eatTime
            )
            sugarEntryDAO.insertSugarEntry(sugarEntry)
        }
    }
}