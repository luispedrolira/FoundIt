package com.luispedrolira.foundit.app.presentation.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.luispedrolira.foundit.app.home.HomeScreen
import com.luispedrolira.foundit.app.missingObject.MissingObjectScreen
import com.luispedrolira.foundit.app.search.SearchScreen
import com.luispedrolira.foundit.app.missingObject.navigateToHome
import com.luispedrolira.foundit.app.missingObject.navigateToMissingObject
import com.luispedrolira.foundit.app.presentation.mainFlow.home.HomeNavigation
import com.luispedrolira.foundit.app.presentation.welcome.WelcomeRoute
import com.luispedrolira.foundit.app.login.LoginRegistrationScreen
import com.luispedrolira.foundit.app.presentation.mainFlow.profile.UserProfileScreen
import com.luispedrolira.foundit.app.presentation.mainFlow.profile.ProfileRoute


@Composable
fun NavApp() {
    val navController = rememberNavController()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = Color.White
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = "welcomeScreen", // Pantalla inicial
            modifier = Modifier.padding(innerPadding)
        ) {
            // WelcomeScreen
            composable("welcomeScreen") {
                WelcomeRoute(
                    onLoginClick = {
                        navController.navigate("login") // Navega a login
                    },
                    onRegisterClick = {
                        navController.navigate("login") // También navega a login
                    }
                )
            }

            // LogInScreen
            composable("login") {
                LoginRegistrationScreen(navController = navController) // Se pasa el navController aquí
            }

            // HomeScreen
            composable("homeScreen") {
                HomeScreen(
                    onNavigateToMissingObject = { category, location, description ->
                        navController.navigate("missingObjectScreen/$category/$location/$description")
                    },
                    onNavigate = { destination ->
                        when (destination) {
                            is HomeNavigation.Search -> {
                                navController.navigate("searchScreen?query=${destination.query}")
                            }
                            is HomeNavigation.Home -> {
                                navController.popBackStack("homeScreen", false)
                            }
                            is HomeNavigation.Profile -> { // Nueva navegación al perfil
                                navController.navigate("profileScreen")
                            }
                        }
                    }
                )
            }

            // SearchScreen
            composable(
                route = "searchScreen?query={query}",
                arguments = listOf(navArgument("query") { type = NavType.StringType })
            ) { backStackEntry ->
                val query = backStackEntry.arguments?.getString("query") ?: ""
                SearchScreen(query)
            }

            // MissingObjectScreen
            composable(
                route = "missingObjectScreen/{category}/{location}/{description}",
                arguments = listOf(
                    navArgument("category") { type = NavType.StringType },
                    navArgument("location") { type = NavType.StringType },
                    navArgument("description") { type = NavType.StringType }
                )
            ) { backStackEntry ->
                val category = backStackEntry.arguments?.getString("category") ?: ""
                val location = backStackEntry.arguments?.getString("location") ?: ""
                val description = backStackEntry.arguments?.getString("description") ?: ""

                MissingObjectScreen(
                    category = category,
                    location = location,
                    description = description,
                    onBackClick = { navController.navigate("homeScreen") }
                )
            }

            // ProfileScreen
            composable("profileScreen") {
                ProfileRoute(
                    onNavigateToHome = {
                        navController.navigate("homeScreen") {
                            popUpTo("homeScreen") { inclusive = true }
                        }
                    },
                    onLogout = {
                        navController.navigate("welcomeScreen") {
                            popUpTo("welcomeScreen") { inclusive = true }
                        }
                    }
                )
            }

        }
    }
}

