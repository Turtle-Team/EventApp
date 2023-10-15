package com.turtleteam.eventapp.di

import com.turtleteam.api.FeatureThreeNavigation
import com.turtleteam.api.FeatureTwoNavigation
import com.turtleteam.impl.navigation.FeatureThreeNavigationImpl
import com.turtleteam.impl.navigation.FeatureTwoNavigationImpl
import com.turtleteam.impl.presentation.FeatureTwoViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val featureThree = module {
    single<FeatureThreeNavigation> { FeatureThreeNavigationImpl() }
}