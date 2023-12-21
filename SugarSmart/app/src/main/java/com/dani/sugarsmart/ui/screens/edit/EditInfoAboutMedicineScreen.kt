package com.dani.sugarsmart.ui.screens.edit

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Edit
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.commandiron.wheel_picker_compose.WheelDateTimePicker
import com.commandiron.wheel_picker_compose.core.TimeFormat
import com.dani.sugarsmart.ui.screens.destinations.CalendarMedicineInfoScreenDestination
import com.dani.sugarsmart.ui.viewmodels.ediit.EditInfoAboutMedicineViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Composable
@Destination
fun EditInfoAboutMedicineScreen(
    navigator: DestinationsNavigator,
    editInfoAboutMedicineViewModel: EditInfoAboutMedicineViewModel = hiltViewModel()
) {
    Surface(modifier = Modifier.fillMaxSize()) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .verticalScroll(rememberScrollState()),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Text(text = "Запись информации о лекарствах")
                OutlinedTextField(
                    value = editInfoAboutMedicineViewModel.medicineNameTextField,
                    onValueChange = editInfoAboutMedicineViewModel::setMedicineName,
                    label = { Text(text = "Название лекарства") }
                )

                WheelDateTimePicker(
                    timeFormat = TimeFormat.HOUR_24,
                    onSnappedDateTime = editInfoAboutMedicineViewModel::setMedicineDateTimeDateTime
                )

                OutlinedTextField(
                    value = editInfoAboutMedicineViewModel.medicineDozeTextField,
                    onValueChange = editInfoAboutMedicineViewModel::setMedicineDoze,
                    label = { Text(text = "Дозировка (мг)") }
                )

                Divider(
                    modifier = Modifier
                        .fillMaxWidth(0.8f)
                        .padding(24.dp)
                )

                Text(text = "Запись приема инсулина")
                OutlinedTextField(
                    value = editInfoAboutMedicineViewModel.insulinNameTextField,
                    onValueChange = editInfoAboutMedicineViewModel::setInsulinName,
                    label = { Text(text = "Название") }
                )

                WheelDateTimePicker(
                    timeFormat = TimeFormat.HOUR_24,
                    onSnappedDateTime = editInfoAboutMedicineViewModel::setInsulinDateTimeDateTime
                )

                OutlinedTextField(
                    value = editInfoAboutMedicineViewModel.insulinDozeTextField,
                    onValueChange = editInfoAboutMedicineViewModel::setInsulinDoze,
                    label = { Text(text = "Дозировка (ME)") }
                )


                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Button(onClick = {
                        editInfoAboutMedicineViewModel.saveMedicineInfoEntry()
                        navigator.navigate(CalendarMedicineInfoScreenDestination)
                    }) {
                        Text(text = "Записать")
                    }

                    Button(onClick = { navigator.navigate(CalendarMedicineInfoScreenDestination) }) {
                        Text(text = "Просмотреть записи")
                    }
                }

                Spacer(modifier = Modifier.padding(64.dp))
            }

            var selectedItem by remember { mutableStateOf(0) }
            val items = listOf(Icons.Rounded.Edit, Icons.Rounded.Email, Icons.Rounded.Notifications)

            NavigationBar(modifier = Modifier.align(Alignment.BottomCenter)) {
                items.forEachIndexed { index, item ->
                    NavigationBarItem(
                        icon = {
                            Icon(
                                imageVector = item,
                                contentDescription = "icon"
                            )
                        },
                        selected = selectedItem == index,
                        onClick = { selectedItem = index },
                        alwaysShowLabel = false
                    )
                }
            }
        }
    }
}