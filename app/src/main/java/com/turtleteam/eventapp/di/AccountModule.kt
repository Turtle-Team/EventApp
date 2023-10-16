package com.turtleteam.eventapp.di

import com.turtleteam.api.navigation.AccountNavigation
import com.turtleteam.impl.navigation.AccountNavigationImpl
import com.turtleteam.impl.navigation.AccountNavigator
import com.turtleteam.impl.presentation.auth.viewModel.AuthViewModel
import com.turtleteam.impl.presentation.register.viewModel.RegisterViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val accountModule = module {
    single<AccountNavigation> { AccountNavigationImpl() }
    factory { navController ->
        AccountNavigator(get(), navController.get())
    }
    viewModel { navigator ->
        AuthViewModel(navigator.get())
    }
    viewModel { navigator ->
        RegisterViewModel(navigator.get())
    }
}