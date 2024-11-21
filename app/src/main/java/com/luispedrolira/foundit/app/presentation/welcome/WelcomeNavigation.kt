package com.luispedrolira.foundit.app.presentation.welcome

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable

@Serializable
data object WelcomeDestination

fun NavGraphBuilder.welcomeScreen(
    onWelcomeClick: () -> Unit
) {
    composable<WelcomeDestination> {
        WelcomeRoute(
            onLoginClick = onWelcomeClick, // Esta función ya no se utilizará, se elimino el button.
            onRegisterClick = onWelcomeClick
        )
    }
}