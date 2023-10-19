package com.turtleteam.impl.presentation.profile.screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.turtleteam.impl.presentation.profile.viewModel.ProfileViewModel

@Composable
fun ProfileScreen(
    viewModel: ProfileViewModel
) {

    Text(
        modifier = Modifier.fillMaxSize(),
        text = "Profile screen"
    )
}