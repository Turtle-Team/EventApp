package com.turtleteam.impl.navigation

import androidx.navigation.NavController
import com.turtleteam.api.navigation.AccountNavigation
import com.turtleteam.api.navigation.HomeNavigation

class HomeNavigator (
    private val homeNavigation: HomeNavigation,
    private val accountNavigation: AccountNavigation,
    private val navController: NavController
) {
    private val homeUrl = homeNavigation.baseUrl
    private val accountUrl = accountNavigation.baseUrl

    fun navigateToAuth() {
        navController.navigate("$accountUrl/auth")
    }
}