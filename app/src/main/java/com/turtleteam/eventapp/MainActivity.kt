package com.turtleteam.eventapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.turtleteam.api.FeatureOneNavigation
import com.turtleteam.api.FeatureThreeNavigation
import com.turtleteam.api.FeatureTwoNavigation
import com.turtleteam.core_navigation.register
import com.turtleteam.impl.navigation.FeatureOneNavigationImpl
import com.turtleteam.impl.navigation.FeatureTwoNavigationImpl
import org.koin.compose.koinInject

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()

            //fixme ubrat v drugoi module
            val featureOne:FeatureOneNavigation = koinInject()
            val featureTwo: FeatureTwoNavigation = koinInject()
            val featureThree: FeatureThreeNavigation = koinInject()
            BottomNavigationBar(
                screen = {
                    NavHost(
                        modifier = Modifier.weight(1f),
                        navController = navController,
                        startDestination = featureOne.baseRoute
                    ) {
                        register(featureOne, navController, Modifier)
                        register(featureTwo, navController, Modifier)
                        register(featureThree, navController, Modifier)
                    }
                },
                routes = listOf(featureOne.baseRoute, featureTwo.baseRoute),
                navController = navController
            )
        }
    }
}


//fixme eto dlya primera verstal
@Composable
fun BottomNavigationBar(
    screen: @Composable ColumnScope.() -> Unit,
    routes: List<String>,
    navController: NavController
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route ?: routes.last()

    Column {
        screen()

        if (routes.contains(currentRoute))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
            ) {
                routes.forEach {
                    Text(
                        modifier = Modifier
                            .fillMaxHeight()
                            .weight(1f)
                            .background(if (currentRoute == it) Color.Red else Color.Blue)
                            .clickable {
                                navController.navigate(it) {
                                    popUpTo(navController.graph.id) {
                                        saveState = true
                                    }
                                    launchSingleTop = true
                                    restoreState = true
                                }
                            },
                        text = it,
                        textAlign = TextAlign.Center
                    )
                }
            }
    }
}