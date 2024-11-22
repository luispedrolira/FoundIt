package com.luispedrolira.foundit.app.missingObject

import kotlinx.serialization.Serializable
import androidx.navigation.NavHostController

@Serializable
sealed class MissingObjectNavigation(val route: String) {
    @Serializable
    object Home : MissingObjectNavigation("homeScreen")

    @Serializable
    data class MissingObject(
        val category: String,
        val location: String,
        val description: String
    ) : MissingObjectNavigation("missingObjectScreen/{category}/{location}/{description}") {
        fun createRoute(): String = "missingObjectScreen/$category/$location/$description"
    }
}

fun NavHostController.navigateToHome() {
    this.navigate(MissingObjectNavigation.Home.route)
}

fun NavHostController.navigateToMissingObject(
    viewModel: MissingObjectViewModel,
    category: String,
    location: String,
    description: String
) {
    viewModel.updateMissingObject(category, location, description)
    this.navigate(MissingObjectNavigation.MissingObject(category, location, description).createRoute())
}
