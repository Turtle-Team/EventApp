package com.turtleteam.impl.presentation.home.screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.turtleteam.impl.presentation.home.viewModel.HomeViewModel

@Composable
fun HomeScreen(
    viewModel: HomeViewModel
) {

    Text("Home Screen")

    TextButton(
        modifier = Modifier.fillMaxSize(),
        onClick = { viewModel.navigateToWelcome() }) {
        Text(text = "Авторизоваться")
    }
}