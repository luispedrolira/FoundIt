package com.luispedrolira.foundit.app.presentation.welcome

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable

@Serializable
data object WelcomeDestination

fun NavGraphBuilder.welcomeScreen(
    onWelcomeClick: () -> Unit
){
    composable<WelcomeDestination> {
        WelcomeRoute(
            onWelcomeClick = onWelcomeClick
        )
    }
}