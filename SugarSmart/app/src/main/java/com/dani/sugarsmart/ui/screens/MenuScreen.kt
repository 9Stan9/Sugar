package com.dani.sugarsmart.ui.screens

import androidx.compose.runtime.setValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBar
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.Icons
import androidx.compose.material3.IconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.BottomAppBar
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.rounded.Edit
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.dani.sugarsmart.ui.screens.destinations.EditCaloriesScreenDestination
import com.dani.sugarsmart.ui.screens.destinations.EditInfoAboutMedicineScreenDestination
import com.dani.sugarsmart.ui.screens.destinations.EditPhysicalScreenDestination
import com.dani.sugarsmart.ui.screens.destinations.EditSugarScreenDestination
import com.dani.sugarsmart.ui.viewmodels.StartViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Composable
@Destination
fun MenuScreen(navigator: DestinationsNavigator) {

    Surface(modifier = Modifier.fillMaxSize()) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Column(
                modifier = Modifier.padding(16.dp, 0.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Button(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = { navigator.navigate(EditSugarScreenDestination) }) {
                    Text(text = "Записать уровень сахара и приём пищи")
                }

                Button(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = { navigator.navigate(EditInfoAboutMedicineScreenDestination) }) {
                    Text(text = "Записать информацию о лекарствах")
                }

                Button(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = { navigator.navigate(EditCaloriesScreenDestination) }) {
                    Text(text = "Записать количество потребляемых калорий")
                }

                Button(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = { navigator.navigate(EditPhysicalScreenDestination) }) {
                    Text(text = "Записать физическую активность")
                }
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
            /*BottomAppBar(
                modifier = Modifier.align(Alignment.BottomCenter),
                actions = {
                    Row(horizontalArrangement = Arrangement.SpaceBetween) {
                        IconButton(
                            onClick = {
                                *//* doSomething() *//*
                            }
                        ) {
                            Icon(
                                imageVector = Icons.Filled.Edit,
                                contentDescription = "Edit"
                            )
                        }

                        IconButton(
                            onClick = {
                                *//* doSomething() *//*
                            }
                        ) {
                            Icon(
                                imageVector = Icons.Filled.Email,
                                contentDescription = "Msg"
                            )
                        }

                        IconButton(
                            onClick = {
                                *//* doSomething() *//*
                            }
                        ) {
                            Icon(
                                imageVector = Icons.Filled.Notifications,
                                contentDescription = "Notification"
                            )
                        }
                    }
                }
            )*/
        }
    }
}