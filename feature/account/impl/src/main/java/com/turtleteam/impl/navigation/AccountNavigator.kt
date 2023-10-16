package com.turtleteam.impl.navigation

import androidx.navigation.NavController
import com.turtleteam.api.navigation.AccountNavigation

private const val REGISTER_URL = "register"

class AccountNavigator (
    private val accountNavigation: AccountNavigation,
    private val navController: NavController
) {
    private val baseUrl = accountNavigation.baseUrl
    fun navigateToRegister() {
        navController.navigate("$baseUrl/$REGISTER_URL")
    }
}