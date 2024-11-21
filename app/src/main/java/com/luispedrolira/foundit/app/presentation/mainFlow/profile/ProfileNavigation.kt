package com.luispedrolira.foundit.app.presentation.mainFlow.profile

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable

@Serializable
data object ProfileDestination

fun NavGraphBuilder.profileScreen(
    onNavigateToHome: () -> Unit,
    onLogout: () -> Unit
) {
    composable<ProfileDestination> {
        ProfileRoute(
            onNavigateToHome = onNavigateToHome,
            onLogout = onLogout
        )
    }
}

