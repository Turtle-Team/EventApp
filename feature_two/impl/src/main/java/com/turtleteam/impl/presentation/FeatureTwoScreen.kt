package com.turtleteam.impl.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun FeatureTwoScreen(
    viewModel: FeatureTwoViewModel
){
    val state = viewModel.state.collectAsState()
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Feature two screen")
        Button(
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Magenta
            ),
            onClick = { viewModel.getEventList() }) {}
        state.value.forEach {
            Text(text = it)
        }
        Button(
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Green
            ),
            onClick = { viewModel.onNextClick() }) {
            Text(text = "Navigate on feature three")
        }
    }
}