package com.luispedrolira.foundit.adminapp.dashboard

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

fun NavGraphBuilder.dashboardNavigation() {
    composable(
        "dashboard",
    ) {
        DashboardContent()
    }
}

fun DashboardContent() {
    TODO("Not yet implemented")
}

fun NavController.navigateToDashboard() {
    this.navigate("dashboard")
}

