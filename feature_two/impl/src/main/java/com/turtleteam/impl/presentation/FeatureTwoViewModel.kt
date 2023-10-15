package com.turtleteam.impl.presentation

import androidx.lifecycle.ViewModel
import com.turtleteam.api.FeatureOneRepository
import com.turtleteam.impl.navigation.FeatureTwoNavigator
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class FeatureTwoViewModel(
    private val rep: FeatureOneRepository,
    private val navigator: FeatureTwoNavigator
): ViewModel() {
    private val _state = MutableStateFlow(listOf<String>())
    val state get() = _state.asStateFlow()

    fun getEventList(){
        _state.value = rep.fetchEvents()
    }
    fun onNextClick(){
        navigator.navigateToFeatureThree(_state.value.firstOrNull()?:"null")
    }
}