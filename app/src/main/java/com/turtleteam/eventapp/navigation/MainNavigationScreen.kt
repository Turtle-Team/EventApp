package com.turtleteam.eventapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import com.turtleteam.api.navigation.AccountNavigation
import com.turtleteam.api.navigation.EventNavigation
import com.turtleteam.api.navigation.HomeNavigation
import com.turtleteam.api.navigation.ProfileNavigation
import com.turtleteam.core_navigation.register
import com.turtleteam.core_view.BottomNavigationBar
import com.turtleteam.core_view.NavigationItem
import com.turtleteam.core_view.R
import org.koin.compose.koinInject

@Composable
fun MainNavigationScreen(navController: NavHostController) {

    val homeFeature: HomeNavigation = koinInject()
    val eventFeature: EventNavigation = koinInject()
    val profileFeature: ProfileNavigation = koinInject()
    val accountFeature: AccountNavigation = koinInject()

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    val navigationItems = listOf(
        NavigationItem(
            route = homeFeature.baseRoute,
            label = R.string.bottom_navigation_view_home,
            icon = R.drawable.ic_home
        ),
        NavigationItem(
            route = eventFeature.baseRoute,
            label = R.string.bottom_navigation_view_event,
            icon = R.drawable.ic_ticket
        ),
        NavigationItem(
            route = profileFeature.baseRoute,
            label = R.string.bottom_navigation_view_profile,
            icon = R.drawable.ic_profile
        )
    )
    BottomNavigationBar(
        screen = {
            NavHost(
                modifier = Modifier.weight(1f),
                navController = navController,
                startDestination = homeFeature.baseRoute
            ) {
                register(homeFeature, navController, Modifier)
                register(eventFeature, navController, Modifier)
                register(profileFeature, navController, Modifier)
                register(accountFeature, navController, Modifier)
            }
        },
        routes = navigationItems,
        currentRoute = currentRoute,
        onClick = {
            navController.navigate(it) {
                popUpTo(navController.graph.id) {
                    saveState = true
                }
                launchSingleTop = true
                restoreState = true
            }
        }
    )
}