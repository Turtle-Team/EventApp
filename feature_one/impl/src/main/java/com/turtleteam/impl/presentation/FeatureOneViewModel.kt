package com.turtleteam.impl.presentation

import androidx.lifecycle.ViewModel
import com.turtleteam.api.FeatureOneRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class FeatureOneViewModel(
    private val rep: FeatureOneRepository
): ViewModel() {
    private val _state = MutableStateFlow(listOf<String>())
    val state get() = _state.asStateFlow()

    fun getEventsList() {
        _state.value = rep.fetchEvents()
    }
}