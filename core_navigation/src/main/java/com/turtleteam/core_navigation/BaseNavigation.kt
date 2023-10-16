package com.turtleteam.core_navigation

import androidx.navigation.NavController

abstract class BaseNavigation(private val navController: NavController) {

    fun onBackButtonClick() {
        navController.popBackStack()
    }
}