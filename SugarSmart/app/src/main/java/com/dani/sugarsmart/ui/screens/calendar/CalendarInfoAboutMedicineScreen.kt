package com.dani.sugarsmart.ui.screens.calendar

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Edit
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.dani.sugarsmart.ui.viewmodels.calendar.CalendarMedicineInfoViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import io.github.boguszpawlowski.composecalendar.SelectableCalendar
import java.time.LocalDate

@Composable
@Destination
fun CalendarMedicineInfoScreen(
    navigator: DestinationsNavigator,
    calendarMedicineInfoViewModel: CalendarMedicineInfoViewModel = hiltViewModel()
) {
    var choseDate by rememberSaveable {
        mutableStateOf<LocalDate?>(null)
    }

    val medicineInfoItems =
        calendarMedicineInfoViewModel.medicineInfoList.filter { it?.medicineTime?.toLocalDate() == choseDate }

    val localDateMedicineInfo =
        calendarMedicineInfoViewModel.medicineInfoList.map { it?.medicineTime?.toLocalDate() }

    Surface(modifier = Modifier.fillMaxSize()) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Column(
                modifier = Modifier.padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(32.dp)
            ) {
                SelectableCalendar(dayContent = { date ->
                    val isMedicineInfoDate = localDateMedicineInfo.contains(date.date)

                    Box(
                        modifier = Modifier
                            .padding(0.dp, 4.dp)
                            .size(50.dp)
                            .clip(RoundedCornerShape(16.dp))
                            .background(
                                if (isMedicineInfoDate) {
                                    MaterialTheme.colorScheme.tertiaryContainer
                                } else {
                                    if (date.isFromCurrentMonth) MaterialTheme.colorScheme.secondaryContainer else MaterialTheme.colorScheme.secondaryContainer.copy(
                                        0.5f
                                    )
                                }
                            )
                            .clickable {
                                if (isMedicineInfoDate) {
                                    choseDate = date.date
                                }
                            },
                        contentAlignment = Alignment.Center
                    ) {
                        Text(text = date.date.dayOfMonth.toString())
                    }
                })
                if (medicineInfoItems.firstOrNull() != null) {
                    LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                        items(medicineInfoItems) {
                            Card {
                                Column(modifier = Modifier.padding(16.dp)) {
                                    Text(
                                        text = "Время: ${
                                            it?.medicineTime?.toLocalTime().toString()
                                        }"
                                    )
                                    Text(text = "Медикамент: ${it?.medicineName}")
                                    Text(text = "Доза: ${it?.medicineDose}")
                                    Text(text = "Инсулин: ${it?.insulinName}")
                                    Text(text = "Доза инсулина: ${it?.insulinDose}")
                                    Text(
                                        text = "Время приема инсулина: ${
                                            it?.insulinTime?.toLocalTime().toString()
                                        }"
                                    )
                                }
                            }
                        }
                    }
                }
            }

            var selectedItem by remember { mutableIntStateOf(0) }
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
