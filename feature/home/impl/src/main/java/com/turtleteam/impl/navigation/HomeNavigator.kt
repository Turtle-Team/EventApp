package com.turtleteam.impl.navigation

import androidx.navigation.NavController
import com.turtleteam.api.navigation.HomeNavigation

class HomeNavigator (
    private val homeNavigation: HomeNavigation,
    private val navController: NavController
) {
    private val baseUrl = homeNavigation.baseUrl
}