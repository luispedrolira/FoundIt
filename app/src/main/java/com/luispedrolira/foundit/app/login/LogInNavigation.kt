package com.luispedrolira.foundit.app.login

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.luispedrolira.foundit.app.presentation.login.LoginRegistrationScreen

fun NavGraphBuilder.loginNavigation(navController: NavController) {
    composable("login") {
        LoginRegistrationScreen(navController = navController) // Se pasa el NavController
    }
}

fun NavController.navigateToLoginScreen() {
    this.navigate("login")
}
