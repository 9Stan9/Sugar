package com.dani.sugarsmart.ui.screens

import android.widget.Space
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.runtime.setValue
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.material3.Text
import androidx.compose.material3.OutlinedTextField
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.commandiron.wheel_picker_compose.core.WheelTextPicker
import com.dani.sugarsmart.ui.screens.destinations.LoginScreenDestination
import com.dani.sugarsmart.ui.screens.destinations.MenuScreenDestination
import com.dani.sugarsmart.ui.screens.destinations.RegistrationScreenDestination
import com.dani.sugarsmart.ui.viewmodels.EnterParametersViewModel
import com.dani.sugarsmart.ui.viewmodels.LoginViewModel
import com.dani.sugarsmart.ui.viewmodels.StartViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Composable
@Destination
fun EnterParametersScreen(
    navigator: DestinationsNavigator,
    enterParametersViewModel: EnterParametersViewModel = hiltViewModel()
) {
    Surface(modifier = Modifier.fillMaxSize()) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Column(
                modifier = Modifier.padding(64.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Text(
                    text = "Ввод параметров",
                    style = MaterialTheme.typography.displayMedium,
                    fontSize = 28.sp
                )

                Spacer(modifier = Modifier.padding(48.dp))

                OutlinedTextField(
                    value = enterParametersViewModel.heightTextField,
                    onValueChange = enterParametersViewModel::setHeight,
                    label = { Text("Рост") },
                    keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number)
                )

                OutlinedTextField(
                    value = enterParametersViewModel.weightTextField,
                    onValueChange = enterParametersViewModel::setWeight,
                    label = { Text("Вес") },
                    keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number)
                )

                OutlinedTextField(
                    value = enterParametersViewModel.ageTextField,
                    onValueChange = enterParametersViewModel::setAge,
                    label = { Text("Возраст") },
                    keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number)
                )

                Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                    WheelTextPicker(texts = enterParametersViewModel.genderPicker, rowCount = 3)

                    WheelTextPicker(
                        texts = enterParametersViewModel.diabetesTypePicker,
                        rowCount = 3
                    )
                }

                FilledTonalButton(
                    modifier = Modifier
                        .fillMaxWidth(),
                    onClick = {
                        navigator.navigate(MenuScreenDestination)
                    }
                ) {
                    Text("Ок")
                }

            }
        }
    }
}