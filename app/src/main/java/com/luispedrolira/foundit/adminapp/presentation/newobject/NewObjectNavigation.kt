package com.luispedrolira.foundit.adminapp.presentation.newobject

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

fun NavGraphBuilder.newObjectNavigation(navController: NavController) {
    composable("newObject") {
        NewObjectContent(navController)
    }
}
