package com.luispedrolira.foundit.adminapp.signupadmin

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.luispedrolira.foundit.adminapp.dashboard.DashboardContent
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import androidx.navigation.NavType

//La navegacion con el serializable estan en la clase del screen.
fun NavGraphBuilder.signUpAdminNavGraph(navController: NavController) {
    navigation(startDestination = "signUpAdmin", route = "signUpAdminRoute") {
        composable(route = "signUpAdmin") {
            SignUpAdminScreen(navController = navController)
        }

        composable(
            route = "dashboard/{args}",
            arguments = listOf(navArgument("args") { type = NavType.StringType })
        ) { backStackEntry ->
            val argsJson = backStackEntry.arguments?.getString("args")
            val args = argsJson?.let { Json.decodeFromString<SignUpAdminArgs>(it) }
            DashboardContent(username = args?.username ?: "")
        }
    }
}



