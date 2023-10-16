package com.turtleteam.eventapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.turtleteam.api.navigation.EventNavigation
import com.turtleteam.api.navigation.HomeNavigation
import com.turtleteam.api.navigation.ProfileNavigation
import com.turtleteam.core_navigation.register
import org.koin.compose.koinInject

@Composable
fun MainNavigationScreen(navController: NavHostController) {

    val homeFeature: HomeNavigation = koinInject()
    val eventFeature: EventNavigation = koinInject()
    val profileFeature: ProfileNavigation = koinInject()
    val accountFeature: ProfileNavigation = koinInject()

    BottomNavigationBar(
        screen = {
            NavHost(
                modifier = Modifier.weight(1f),
                navController = navController,
                startDestination = homeFeature.baseUrl
            ) {
                register(homeFeature, navController, Modifier)
                register(eventFeature, navController, Modifier)
                register(profileFeature, navController, Modifier)
                register(accountFeature, navController, Modifier)
            }
        },
        routes = listOf(homeFeature.baseUrl, eventFeature.baseUrl, profileFeature.baseUrl),
        navController = navController
    )
}