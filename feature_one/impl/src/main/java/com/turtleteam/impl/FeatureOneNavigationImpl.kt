package com.turtleteam.impl

import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.turtleteam.api.FeatureOneNavigation
import com.turtleteam.impl.presentation.FeatureOneScreen

class FeatureOneNavigationImpl: FeatureOneNavigation {
    override val baseRoute: String = "FeatureOneScreen"

    override fun registerGraph(
        navGraphBuilder: NavGraphBuilder,
        navController: NavController,
        modifier: Modifier
    ) {
        navGraphBuilder.composable(route = baseRoute) {
            FeatureOneScreen()
        }
    }
}