package com.luispedrolira.foundit.app.presentation.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings // Usamos Settings para Admin
import androidx.compose.ui.graphics.vector.ImageVector
import com.luispedrolira.foundit.app.presentation.mainFlow.home.HomeNavigation
import com.luispedrolira.foundit.app.presentation.mainFlow.profile.ProfileDestination

data class NavItem(
    val title: String,
    val icon: ImageVector,
    val destination: Any // Permite manejar cadenas o rutas de navegación
)

val navigationItems = listOf(
    NavItem(
        title = "Home",
        icon = Icons.Default.Home,
        destination = HomeNavigation.Home // Uso de HomeNavigation.Home
    ),
    NavItem(
        title = "Buscar",
        icon = Icons.Default.Search,
        destination = HomeNavigation.Search() // HomeNavigation para Search
    ),
    NavItem(
        title = "Perfil",
        icon = Icons.Default.Person,
        destination = ProfileDestination // Uso de ProfileDestination
    ),
    NavItem( // Ítem para Admin
        title = "Admin",
        icon = Icons.Default.Settings, // Cambiamos a Settings
        destination = "dashboard" // Ruta hacia el Dashboard
    )
)
