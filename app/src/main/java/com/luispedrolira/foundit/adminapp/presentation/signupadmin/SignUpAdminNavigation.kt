package com.luispedrolira.foundit.adminapp.signupadmin

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.luispedrolira.foundit.adminapp.presentation.signupadmin.SignUpAdminArgs
import com.luispedrolira.foundit.adminapp.presentation.signupadmin.SignUpAdminScreen
import kotlinx.serialization.json.Json

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
            argsJson?.let { Json.decodeFromString<SignUpAdminArgs>(it) }
            DashboardContent1()
        }
    }
}

fun DashboardContent1() {
        TODO("Not yet implemented")
}



