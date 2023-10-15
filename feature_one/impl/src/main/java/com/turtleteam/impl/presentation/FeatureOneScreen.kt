package com.turtleteam.impl.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import org.koin.androidx.compose.koinViewModel

@Composable
fun FeatureOneScreen(
    viewModel: FeatureOneViewModel = koinViewModel()
) {
    val state = viewModel.state.collectAsState()
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = "feature one",
            textAlign = TextAlign.Center
        )
        Button(onClick = { viewModel.getEventsList() }) {

        }
        state.value.forEach {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = it,
                textAlign = TextAlign.Center
            )
        }
    }
}