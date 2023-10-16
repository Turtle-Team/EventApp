package com.turtleteam.eventapp.navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.turtleteam.eventapp.R


data class NavigationItem(
    val route: String,
    val label: String,
    val icon: Int
)

@Composable
fun BottomNavigationBar(
    screen: @Composable ColumnScope.() -> Unit,
    routes: List<String>,
    navController: NavController
) {

    val navigationItems = listOf(
        NavigationItem(
            route = routes[0],
            label = "Главная",
            icon = R.drawable.ic_home
        ),
        NavigationItem(
            route = routes[1],
            label = "Мои мероприятия",
            icon = R.drawable.ic_ticket
        ),
        NavigationItem(
            route = routes[2],
            label = "Профиль",
            icon = R.drawable.ic_profile
        )
    )
    Column {
        screen()

        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route ?: routes.last()

        if (routes.contains(currentRoute)) {
            NavigationBar {
                navigationItems.forEach { item ->
                    NavigationBarItem(
                        selected = currentRoute == item.route,
                        label = {
                            Text(
                                item.label,
                                color = if (currentRoute == item.route) Color(0xFF1D192B) else Color(
                                    0xFF49454F
                                )
                            )
                        },
                        onClick = {
                            navController.navigate(item.route) {
                                popUpTo(navController.graph.id) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        },
                        icon = {
                            Icon(
                                painter = painterResource(id = item.icon),
                                contentDescription = "",
                                tint = if (currentRoute == item.route) Color(0xFF1D192B) else Color(
                                    0xFF49454F
                                ),
                                modifier = Modifier.size(24.dp)
                            )
                        })
                }
            }
        }
    }
}