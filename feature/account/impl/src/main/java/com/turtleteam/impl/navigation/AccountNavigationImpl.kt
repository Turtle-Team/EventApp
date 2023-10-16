package com.turtleteam.impl.navigation

import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.turtleteam.api.navigation.AccountNavigation
import com.turtleteam.impl.presentation.auth.screen.AuthScreen
import com.turtleteam.impl.presentation.register.screen.RegisterScreen
import org.koin.androidx.compose.koinViewModel
import org.koin.compose.koinInject
import org.koin.core.parameter.parametersOf

class AccountNavigationImpl : AccountNavigation {

    override val baseUrl: String = "account"

    override fun registerGraph(
        navGraphBuilder: NavGraphBuilder,
        navController: NavController,
        modifier: Modifier
    ) {
        navGraphBuilder.composable(route = "$baseUrl/auth") {
            val navigator =
                koinInject<AccountNavigator>(parameters = { parametersOf(navController) })
            AuthScreen(
                viewModel = koinViewModel(parameters = { parametersOf(navigator) })
            )
        }
        navGraphBuilder.composable(route = "$baseUrl/register") {
            val navigator =
                koinInject<AccountNavigator>(parameters = { parametersOf(navController) })
            RegisterScreen(
                viewModel = koinViewModel(parameters = { parametersOf(navigator) })
            )
        }
    }
}