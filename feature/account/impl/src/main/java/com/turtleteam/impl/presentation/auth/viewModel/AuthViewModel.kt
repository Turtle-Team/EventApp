package com.turtleteam.impl.presentation.auth.viewModel

import androidx.lifecycle.ViewModel
import com.turtleteam.impl.navigation.AccountNavigator

class AuthViewModel(
    private val navigator: AccountNavigator
): ViewModel() {

    fun navigateToRegister() {
        navigator.navigateToRegister()
    }
}