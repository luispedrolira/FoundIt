package com.luispedrolira.foundit.app.presentation.mainFlow.profile

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable

@Serializable
data object ProfileDestination

fun NavGraphBuilder.profileScreen(){
    composable<ProfileDestination> {
        ProfileRoute()
    }
}