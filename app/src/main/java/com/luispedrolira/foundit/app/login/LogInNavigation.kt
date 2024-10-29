package com.luispedrolira.foundit.app.login

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

fun NavGraphBuilder.loginNavigation() {
    composable("login") {
        LoginRegistrationScreen()
    }
}

fun NavController.navigateToLoginScreen() {
    this.navigate("login")
}
