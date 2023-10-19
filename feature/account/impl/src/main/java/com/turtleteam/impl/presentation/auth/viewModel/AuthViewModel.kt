package com.turtleteam.impl.presentation.auth.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.turtleteam.api.data.api.service.AccountService
import com.turtleteam.impl.navigation.AccountNavigator
import com.turtleteam.impl.presentation.auth.state.AuthState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class AuthViewModel(
    private val navigator: AccountNavigator,
    private val accountService: AccountService
) : ViewModel() {

    private val _state = MutableStateFlow(AuthState())
    val state = _state.asStateFlow()

    fun onBackButtonClick() {
        navigator.onBackButtonClick()
    }

    fun onLoginTextChanged(login: String) {
        _state.update { it.copy(loginText = login) }
    }

    fun onPasswordTextChanged(password: String) {
        _state.update { it.copy(passwordText = password) }
    }

    fun navigateToRegister() {
        navigator.navigateToRegister()
    }

    fun onAuthClick(login: String, password: String) {
        viewModelScope.launch(Dispatchers.IO) {
            kotlin.runCatching {
                accountService.authUser(login, password)
            }
                .onFailure {
                    Log.e("ajdqwjdqwdjqoiwdj", it.toString())
                }
        }
    }
}