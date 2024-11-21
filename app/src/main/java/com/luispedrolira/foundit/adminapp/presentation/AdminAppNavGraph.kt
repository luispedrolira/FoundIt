package com.luispedrolira.foundit.adminapp.presentation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.luispedrolira.foundit.adminapp.presentation.dashboard.DashboardContent1
import com.luispedrolira.foundit.adminapp.presentation.newobject.newObjectNavigation

fun NavGraphBuilder.adminAppNavGraph(navController: NavController) {
    composable("dashboard") {
        DashboardContent1(
            onObjectClick = {},
            navController = navController
        )
    }
    newObjectNavigation(navController)
}
