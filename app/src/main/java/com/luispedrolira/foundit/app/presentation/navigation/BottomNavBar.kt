package com.luispedrolira.foundit.app.presentation.navigation

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.luispedrolira.foundit.app.presentation.mainFlow.home.HomeNavigation

@Composable
fun BottomNavBar(
    checkItemSelected: (HomeNavigation) -> Unit,
    onNavItemClick: (Any) -> Unit
) {
    NavigationBar {
        navigationItems.forEach { navItem ->
            val isItemSelected = checkItemSelected(navItem.destination)
            NavigationBarItem(
                selected = isItemSelected,
                label = { if (isItemSelected) Text(text = navItem.title) },
                onClick = { onNavItemClick(navItem.destination) },
                icon = { Icon(imageVector = navItem.icon, contentDescription = navItem.title) }
            )
        }
    }
}
