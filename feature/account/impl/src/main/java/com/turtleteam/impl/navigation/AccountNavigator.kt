package com.turtleteam.impl.navigation

import androidx.navigation.NavController
import com.turtleteam.api.navigation.AccountNavigation
import com.turtleteam.core_navigation.BaseNavigation

private const val REGISTER_ROUTE = "register"
private const val AUTH_ROUTE = "auth"

class AccountNavigator (
    private val accountNavigation: AccountNavigation,
    private val navController: NavController
): BaseNavigation(navController) {
    private val baseRoute = accountNavigation.baseRoute

    fun navigateToAuth() {
        navController.navigate("$baseRoute/$AUTH_ROUTE")
    }

    fun navigateToRegister() {
        navController.navigate("$baseRoute/$REGISTER_ROUTE")
    }
}