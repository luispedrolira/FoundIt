package com.luispedrolira.foundit.app.presentation.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector
import com.luispedrolira.foundit.app.presentation.mainFlow.profile.ProfileDestination
import com.luispedrolira.foundit.app.presentation.mainFlow.searchNONUSE.SearchDestination

data class NavItem(
    val title: String,
    val icon: ImageVector,
    val destination: Any
)

val navigationItems = listOf(
    NavItem(
        title = "Home",
        icon = Icons.Default.Home,
        destination = SearchDestination
    ),
    NavItem(
        title = "Buscar",
        icon = Icons.Default.Search,
        destination = SearchDestination
    ),
    NavItem(
        title = "Perfil",
        icon = Icons.Default.Person,
        destination = ProfileDestination
    )
)