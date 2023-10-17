package com.turtleteam.eventapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.navigation.compose.rememberNavController
import com.turtleteam.core_view.theme.EventAppTheme
import com.turtleteam.eventapp.navigation.MainNavigationScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()

            EventAppTheme {
                MainNavigationScreen(navController = navController)
            }
        }
    }
}
