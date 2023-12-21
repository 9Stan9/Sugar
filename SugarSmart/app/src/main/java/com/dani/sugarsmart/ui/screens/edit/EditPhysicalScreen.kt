package com.dani.sugarsmart.ui.screens.edit

import androidx.compose.material3.TextField
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.DropdownMenuItem
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
import com.commandiron.wheel_picker_compose.WheelDatePicker
import com.commandiron.wheel_picker_compose.WheelDateTimePicker
import com.commandiron.wheel_picker_compose.WheelTimePicker
import com.commandiron.wheel_picker_compose.core.TimeFormat
import com.dani.sugarsmart.ui.screens.destinations.CalendarPhysicalActivityScreenDestination
import com.dani.sugarsmart.ui.viewmodels.ediit.EditPhysicalViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Destination
fun EditPhysicalScreen(
    navigator: DestinationsNavigator,
    editPhysicalViewModel: EditPhysicalViewModel = hiltViewModel()
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
                var dropdownRunState by remember { mutableStateOf(false) }
                var dropdownTempState by remember { mutableStateOf(false) }
                val optionsRun = listOf("Ходьба", "Бег")
                val optionsTemp = listOf("Низкая", "Средняя", "Высокая")

                Text(text = "Запись количества потребленных калорий")

                ExposedDropdownMenuBox(
                    expanded = dropdownRunState,
                    onExpandedChange = { dropdownRunState = !dropdownRunState },
                ) {
                    TextField(
                        modifier = Modifier.menuAnchor(),
                        readOnly = true,
                        value = editPhysicalViewModel.activityType,
                        onValueChange = {},
                        label = { Text("Тип активности") },
                        trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = dropdownRunState) },
                        colors = ExposedDropdownMenuDefaults.textFieldColors()
                    )

                    ExposedDropdownMenu(
                        expanded = dropdownRunState,
                        onDismissRequest = { dropdownRunState = false },
                    ) {
                        optionsRun.forEach { selectionOption ->
                            DropdownMenuItem(
                                text = { Text(selectionOption) },
                                onClick = {
                                    editPhysicalViewModel.activityType = selectionOption
                                    dropdownRunState = false
                                },
                                contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding
                            )
                        }
                    }
                }

                WheelDateTimePicker(
                    timeFormat = TimeFormat.HOUR_24,
                    onSnappedDateTime = editPhysicalViewModel::setDate
                )

                Text(text = "Длительность активности (часы:минуты)")

                WheelTimePicker(
                    timeFormat = TimeFormat.HOUR_24,
                    onSnappedTime = editPhysicalViewModel::setActivityTime
                )


                ExposedDropdownMenuBox(
                    expanded = dropdownTempState,
                    onExpandedChange = { dropdownTempState = !dropdownTempState },
                ) {
                    TextField(
                        modifier = Modifier.menuAnchor(),
                        readOnly = true,
                        value = editPhysicalViewModel.intensiveType,
                        onValueChange = {},
                        label = { Text("Интенсивность") },
                        trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = dropdownTempState) },
                        colors = ExposedDropdownMenuDefaults.textFieldColors()
                    )

                    ExposedDropdownMenu(
                        expanded = dropdownTempState,
                        onDismissRequest = { dropdownTempState = false },
                    ) {
                        optionsTemp.forEach { selectionOption ->
                            DropdownMenuItem(
                                text = { Text(selectionOption) },
                                onClick = {
                                    editPhysicalViewModel.intensiveType = selectionOption
                                    dropdownTempState = false
                                },
                                contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding
                            )
                        }
                    }
                }

                OutlinedTextField(
                    value = editPhysicalViewModel.distanceTextField,
                    onValueChange = editPhysicalViewModel::setDistance,
                    label = { Text(text = "Расстояние в км") })

                OutlinedTextField(
                    value = editPhysicalViewModel.pulseTextField,
                    onValueChange = editPhysicalViewModel::setPulse,
                    label = { Text(text = "Пульс") })

                OutlinedTextField(
                    value = editPhysicalViewModel.caloriesTextField,
                    onValueChange = editPhysicalViewModel::setCalories,
                    label = { Text(text = "Потраченные калории") })

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Button(onClick = {
                        editPhysicalViewModel.savePhysicalActivityEntry()
                        navigator.navigate(CalendarPhysicalActivityScreenDestination)
                    }) {
                        Text(text = "Записать")
                    }

                    Button(onClick = { navigator.navigate(CalendarPhysicalActivityScreenDestination) }) {
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