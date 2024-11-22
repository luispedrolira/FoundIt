package com.luispedrolira.foundit.app.presentation.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.luispedrolira.foundit.app.presentation.mainFlow.home.HomeScreen
import com.luispedrolira.foundit.app.missingObject.MissingObjectScreen
import com.luispedrolira.foundit.app.search.SearchScreen
import com.luispedrolira.foundit.app.presentation.mainFlow.home.HomeNavigation
import com.luispedrolira.foundit.app.presentation.welcome.WelcomeRoute
import com.luispedrolira.foundit.app.presentation.login.LoginRegistrationScreen
import com.luispedrolira.foundit.app.presentation.mainFlow.profile.ProfileRoute
import com.luispedrolira.foundit.adminapp.presentation.dashboard.DashboardContent1
import com.luispedrolira.foundit.adminapp.presentation.newobject.NewObjectContent
import com.luispedrolira.foundit.adminapp.presentation.dashboard.Objeto

// Lista mutable compartida entre pantallas para objetos encontrados
val objetos = mutableStateListOf<Objeto>()

@Composable
fun NavApp() {
    val navController = rememberNavController()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = Color.White
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = "welcomeScreen",
            modifier = Modifier.padding(innerPadding)
        ) {
            // Pantalla de bienvenida
            composable("welcomeScreen") {
                WelcomeRoute(
                    onLoginClick = { navController.navigate("login") },
                    onRegisterClick = { navController.navigate("login") }
                )
            }

            // Pantalla de inicio de sesión
            composable("login") {
                LoginRegistrationScreen(
                    navController = navController,
                    onLoginSuccess = { isAdmin ->
                        if (isAdmin) {
                            navController.navigate("dashboardScreen")
                        } else {
                            navController.navigate("homeScreen")
                        }
                    }
                )
            }

            // Pantalla principal (Home)
            composable("homeScreen") {
                HomeScreen(
                    onNavigateToMissingObject = { category, location, description ->
                        navController.navigate("missingObjectScreen/$category/$location/$description")
                    },
                    onNavigate = { destination ->
                        when (destination) {
                            is HomeNavigation.Search -> navController.navigate("searchScreen?query=${destination.query}")
                            is HomeNavigation.Home -> navController.popBackStack("homeScreen", false)
                            is HomeNavigation.Profile -> navController.navigate("profileScreen")
                        }
                    }
                )
            }

            // Pantalla de búsqueda
            composable(
                route = "searchScreen?query={query}",
                arguments = listOf(navArgument("query") { type = NavType.StringType })
            ) { backStackEntry ->
                val query = backStackEntry.arguments?.getString("query") ?: ""
                SearchScreen(query)
            }

            // Pantalla de detalles de objetos perdidos
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

            // Pantalla de perfil
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

            // Pantalla del administrador (Dashboard)
            composable("dashboardScreen") {
                DashboardContent1(
                    navController = navController,
                    objeto = objetos
                )
            }

            // Pantalla para agregar nuevos objetos
            composable("newObject") {
                NewObjectContent(
                    onBackClick = { navController.popBackStack() },
                    navController = navController,
                    addObject = { newObject ->
                        objetos.add(newObject) // Agregar el objeto a la lista compartida
                    }
                )
            }
        }
    }
}
