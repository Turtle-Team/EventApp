package com.turtleteam.impl.navigation

import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.turtleteam.api.FeatureTwoNavigation
import com.turtleteam.impl.presentation.FeatureTwoScreen
import org.koin.androidx.compose.koinViewModel
import org.koin.compose.koinInject
import org.koin.core.parameter.parametersOf

class FeatureTwoNavigationImpl: FeatureTwoNavigation {
    override val baseRoute: String = "FeatureTwoScreen"

    override fun registerGraph(
        navGraphBuilder: NavGraphBuilder,
        navController: NavController,
        modifier: Modifier
    ) {
        navGraphBuilder.composable(route = baseRoute) {
            val navigator = koinInject<FeatureTwoNavigator>(parameters = { parametersOf(navController) })
            FeatureTwoScreen(
                viewModel = koinViewModel(parameters = { parametersOf(navigator) })
            )
        }
    }
}