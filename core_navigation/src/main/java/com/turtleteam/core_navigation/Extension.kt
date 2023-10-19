package com.turtleteam.core_navigation

import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController

fun NavGraphBuilder.register(
    featureApi: NavigationApi,
    navController: NavHostController,
) {
    featureApi.registerGraph(
        navGraphBuilder = this,
        navController = navController,
    )
}