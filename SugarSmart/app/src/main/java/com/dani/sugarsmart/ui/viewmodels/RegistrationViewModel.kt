package com.dani.sugarsmart.ui.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dani.sugarsmart.data.user.dao.UserDAO
import com.dani.sugarsmart.data.user.dto.UserDTO
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegistrationViewModel @Inject constructor(val userDAO: UserDAO) : ViewModel() {
    var loginTextField by mutableStateOf("")
    var passwordTextField by mutableStateOf("")
    var retryPasswordTextField by mutableStateOf("")
    var error by mutableStateOf("")

    fun setLogin(value: String) {
        loginTextField = value
    }

    fun setPassword(value: String) {
        passwordTextField = value
    }

    fun setRetryPassword(value: String) {
        retryPasswordTextField = value
    }

    fun clearError() {
        error = ""
    }

    fun register(onSuccess: () -> Unit) {
        viewModelScope.launch {
            // Проверяем, что поля не пустые
            if (loginTextField.isEmpty()) {
                // Отображаем ошибку
                error = "Введите логин"
                cancel()
            }
            if (passwordTextField.isEmpty()) {
                // Отображаем ошибку
                error = "Введите пароль"
                cancel()
            }

            // Проверяем, совпадают ли пароли
            if (passwordTextField != retryPasswordTextField) {
                // Отображаем ошибку
                error = "Пароли не совпадают"
                cancel()
            }

            val users = userDAO.insert(UserDTO(null, loginTextField, passwordTextField))

            onSuccess()
        }
    }
}