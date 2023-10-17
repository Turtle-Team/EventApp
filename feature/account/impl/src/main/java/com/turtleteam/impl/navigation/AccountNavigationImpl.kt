package com.turtleteam.impl.navigation

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.turtleteam.api.navigation.AccountNavigation
import com.turtleteam.impl.presentation.auth.screen.AuthScreen
import com.turtleteam.impl.presentation.register.screen.RegisterScreen
import org.koin.androidx.compose.koinViewModel
import org.koin.compose.koinInject
import org.koin.core.parameter.parametersOf

class AccountNavigationImpl : AccountNavigation {

    override val baseRoute: String = "account"
    private val authRoute = "$baseRoute/auth"
    private val registerRoute = "$baseRoute/register"

    private val animDuration = 500

    override fun registerGraph(
        navGraphBuilder: NavGraphBuilder,
        navController: NavController,
        modifier: Modifier
    ) {
        navGraphBuilder.navigation(startDestination = authRoute, route = baseRoute) {
            composable(
                route = authRoute,
                enterTransition = {
                    slideIntoContainer(
                        AnimatedContentTransitionScope.SlideDirection.Left,
                        animationSpec = tween(animDuration)
                    )
                },
                popEnterTransition = {
                    slideIntoContainer(
                        AnimatedContentTransitionScope.SlideDirection.Right,
                        animationSpec = tween(animDuration)
                    )
                },
                exitTransition = {
                    slideOutOfContainer(
                        AnimatedContentTransitionScope.SlideDirection.Left,
                        animationSpec = tween(animDuration)
                    )
                },
                popExitTransition = {
                    slideOutOfContainer(
                        AnimatedContentTransitionScope.SlideDirection.Right,
                        animationSpec = tween(animDuration)
                    )
                }
            ) {
                val navigator =
                    koinInject<AccountNavigator>(parameters = { parametersOf(navController) })
                AuthScreen(
                    modifier = modifier,
                    viewModel = koinViewModel(parameters = { parametersOf(navigator) })
                )
            }
            composable(route = registerRoute,
                enterTransition = {
                    slideIntoContainer(
                        AnimatedContentTransitionScope.SlideDirection.Left,
                        animationSpec = tween(animDuration)
                    )
                },
                popExitTransition = {
                    slideOutOfContainer(
                        AnimatedContentTransitionScope.SlideDirection.Right,
                        animationSpec = tween(animDuration)
                    )
                },
                exitTransition = {
                    slideOutOfContainer(
                        AnimatedContentTransitionScope.SlideDirection.Left,
                        animationSpec = tween(animDuration)
                    )
                },
                popEnterTransition = {
                    slideIntoContainer(
                        AnimatedContentTransitionScope.SlideDirection.Right,
                        animationSpec = tween(animDuration)
                    )
                }
            ) {
                val navigator =
                    koinInject<AccountNavigator>(parameters = { parametersOf(navController) })
                RegisterScreen(
                    modifier = modifier,
                    viewModel = koinViewModel(parameters = { parametersOf(navigator) })
                )
            }
        }
    }
}