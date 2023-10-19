package com.turtleteam.impl.navigation

import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.turtleteam.api.navigation.ProfileNavigation
import com.turtleteam.impl.presentation.profile.screen.ProfileScreen
import org.koin.androidx.compose.koinViewModel
import org.koin.compose.koinInject
import org.koin.core.parameter.parametersOf

class ProfileNavigationImpl : ProfileNavigation {

    override val baseRoute: String = "profile"

    override fun registerGraph(
        navGraphBuilder: NavGraphBuilder,
        navController: NavController,
    ) {
        navGraphBuilder.composable(route = baseRoute) {
            val navigator =
                koinInject<ProfileNavigator>(parameters = { parametersOf(navController) })
            ProfileScreen(
                viewModel = koinViewModel(parameters = { parametersOf(navigator) })
            )
        }
    }
}