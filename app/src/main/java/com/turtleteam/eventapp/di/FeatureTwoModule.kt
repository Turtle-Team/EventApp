package com.turtleteam.eventapp.di

import com.turtleteam.api.FeatureTwoNavigation
import com.turtleteam.impl.navigation.FeatureTwoNavigationImpl
import com.turtleteam.impl.navigation.FeatureTwoNavigator
import com.turtleteam.impl.presentation.FeatureTwoViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val featureTwo = module {
    single<FeatureTwoNavigation> { FeatureTwoNavigationImpl() }
    factory { navController ->
        FeatureTwoNavigator(get(), get(), navController.get())
    }
    viewModel { navigator ->
        FeatureTwoViewModel(get(), navigator.get())
    }
}