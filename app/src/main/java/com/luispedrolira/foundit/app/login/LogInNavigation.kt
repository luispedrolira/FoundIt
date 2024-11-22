package com.luispedrolira.foundit.app.login

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.luispedrolira.foundit.app.presentation.login.LoginRegistrationScreen

fun NavGraphBuilder.loginNavigation(navController: NavController) {
    composable("login") {
        LoginRegistrationScreen(
            navController = navController,
            onLoginSuccess = { isAdmin ->
                if (isAdmin) {
                    navController.navigateToDashboardScreen()
                } else {
                    navController.navigateToHomeScreen()
                }
            }
        )
    }
}

fun NavController.navigateToLoginScreen() {
    this.navigate("login")
}

fun NavController.navigateToDashboardScreen() {
    this.navigate("dashboardScreen") // Ruta para la pantalla de administrador
}

fun NavController.navigateToHomeScreen() {
    this.navigate("homeScreen") // Ruta para la pantalla de estudiante
}
