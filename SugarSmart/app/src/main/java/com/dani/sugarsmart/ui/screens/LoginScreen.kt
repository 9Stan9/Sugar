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
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.dani.sugarsmart.ui.screens.destinations.EnterParametersScreenDestination
import com.dani.sugarsmart.ui.screens.destinations.LoginScreenDestination
import com.dani.sugarsmart.ui.screens.destinations.RegistrationScreenDestination
import com.dani.sugarsmart.ui.viewmodels.LoginViewModel
import com.dani.sugarsmart.ui.viewmodels.StartViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Composable
@Destination
fun LoginScreen(
    navigator: DestinationsNavigator,
    loginViewModel: LoginViewModel = hiltViewModel()
) {
    Surface(modifier = Modifier.fillMaxSize()) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            if (loginViewModel.error.isNotEmpty()) {
                TextButton(
                    modifier = Modifier.align(Alignment.TopCenter),
                    onClick = loginViewModel::clearError
                ) {
                    Text(loginViewModel.error)
                }
            }

            Column(
                modifier = Modifier.padding(64.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Text(
                    text = "Вход в SugarSmart",
                    style = MaterialTheme.typography.displayMedium,
                    fontSize = 28.sp
                )

                Spacer(modifier = Modifier.padding(48.dp))

                OutlinedTextField(
                    value = loginViewModel.loginTextField,
                    onValueChange = loginViewModel::setLogin,
                    label = { Text("Почта") }
                )

                OutlinedTextField(
                    value = loginViewModel.passwordTextField,
                    onValueChange = loginViewModel::setPassword,
                    label = { Text("Пароль") },
                    visualTransformation = PasswordVisualTransformation()
                )

                FilledTonalButton(
                    modifier = Modifier
                        .fillMaxWidth(),
                    onClick = {
                        loginViewModel.login {
                            navigator.navigate(EnterParametersScreenDestination)
                        }
                    }
                ) {
                    Text("Войти")
                }


                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(text = "Еще не зарегестрированы?")

                    TextButton(
                        onClick = { navigator.navigate(RegistrationScreenDestination) },
                        colors = ButtonDefaults.textButtonColors(contentColor = MaterialTheme.colorScheme.primary)
                    ) {
                        Text(text = "Регистрация")
                    }
                }
            }
        }
    }
}