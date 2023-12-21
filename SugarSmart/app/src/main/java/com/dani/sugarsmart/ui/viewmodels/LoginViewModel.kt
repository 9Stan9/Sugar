package com.dani.sugarsmart.ui.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dani.sugarsmart.data.user.dao.UserDAO
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(val userDAO: UserDAO) : ViewModel() {
    var loginTextField by mutableStateOf("")
    var passwordTextField by mutableStateOf("")
    var error by mutableStateOf("")

    fun setLogin(value: String) {
        loginTextField = value
    }

    fun setPassword(value: String) {
        passwordTextField = value
    }

    fun clearError() {
        error = ""
    }

    fun login(onSuccess: () -> Unit) {
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

            // Получаем пользователя по логину
            val user = userDAO.getUserByLoginAndPassword(loginTextField, passwordTextField)

            // Проверяем, существует ли такой пользователь
            if (user == null) {
                // Отображаем ошибку
                error = "Пользователь не найден"
                cancel()
            } else {
                onSuccess()
            }
        }
    }
}