package com.turtleteam.eventapp.di

import com.turtleteam.api.FeatureOneNavigation
import com.turtleteam.api.FeatureOneRepository
import com.turtleteam.impl.FeatureOneNavigationImpl
import com.turtleteam.impl.data.FeatureOneRepositoryImpl
import com.turtleteam.impl.presentation.FeatureOneViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val featureOne = module {
    single<FeatureOneNavigation> { FeatureOneNavigationImpl() }
    single<FeatureOneRepository> { FeatureOneRepositoryImpl() }
    viewModel { FeatureOneViewModel(get()) }
}