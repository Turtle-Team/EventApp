package com.turtleteam.impl.navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.turtleteam.api.FeatureThreeNavigation

class FeatureThreeNavigationImpl : FeatureThreeNavigation {

    override val baseRoute: String = "FeatureThreeScreen"

    override fun registerGraph(
        navGraphBuilder: NavGraphBuilder,
        navController: NavController,
        modifier: Modifier
    ) {
        navGraphBuilder.composable(
            "$baseRoute/{str}",
            arguments = listOf(navArgument("str") {
                type = NavType.StringType
                nullable = true
            })
        ) {
            val args = it.arguments?.getString("str", "no_args")
            Column {
                Text(baseRoute)
                Text("args: $args")
            }
        }
    }

}