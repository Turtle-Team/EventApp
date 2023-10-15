package com.turtleteam.eventapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.turtleteam.api.FeatureOneNavigation
import com.turtleteam.core_navigation.register
import com.turtleteam.impl.FeatureOneNavigationImpl
import org.koin.compose.koinInject

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()

            //fixme ubrat v drugoi module
            val featureOne = remember { FeatureOneNavigationImpl() as FeatureOneNavigation }

            NavHost(
                navController = navController,
                startDestination = "FeatureOneScreen"
            ) {
                register(featureOne, navController, Modifier)
            }
        }
    }
}

