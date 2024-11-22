package com.luispedrolira.foundit.adminapp.newobject

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.luispedrolira.foundit.adminapp.presentation.newobject.NewObjectContent

fun NavGraphBuilder.newObjectNavigation(navController: NavController) {
    composable("newObject") {
        NewObjectContent(
            onBackClick = { navController.popBackStack() },
            navController = navController
        )
    }
}

