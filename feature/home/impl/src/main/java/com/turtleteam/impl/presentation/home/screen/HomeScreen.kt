package com.turtleteam.impl.presentation.home.screen

import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import com.turtleteam.impl.presentation.home.viewModel.HomeViewModel

@Composable
fun HomeScreen(viewModel: HomeViewModel) {

    Text("Home Screen")

    TextButton(onClick = { viewModel.navigateToAuth() }) {
        Text(text = "Авторизоваться")
    }
}