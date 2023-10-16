package com.turtleteam.impl.presentation.auth.viewModel

import androidx.lifecycle.ViewModel
import com.turtleteam.impl.navigation.AccountNavigator
import com.turtleteam.impl.presentation.auth.state.AuthState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class AuthViewModel(
    private val navigator: AccountNavigator
): ViewModel() {

    private val _state = MutableStateFlow(AuthState())
    val state = _state.asStateFlow()

    fun onLoginTextChanged(login: String) {
        _state.update { it.copy(loginText = login) }
    }

    fun onPasswordTextChanged(password: String){
        _state.update { it.copy(passwordText = password) }
    }

    fun navigateToRegister() {
        navigator.navigateToRegister()
    }
}