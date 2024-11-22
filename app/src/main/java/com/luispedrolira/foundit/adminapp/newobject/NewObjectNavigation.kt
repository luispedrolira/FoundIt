package com.luispedrolira.foundit.adminapp.newobject

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.luispedrolira.foundit.adminapp.presentation.newobject.NewObjectContent
import com.luispedrolira.foundit.adminapp.presentation.dashboard.Objeto

fun NavGraphBuilder.newObjectNavigation(
    navController: NavController,
    addObject: (Objeto) -> Unit // Callback para agregar un nuevo objeto
) {
    composable("newObject") {
        NewObjectContent(
            onBackClick = { navController.popBackStack() }, // Regresar al stack anterior
            navController = navController,
            addObject = addObject // Pasar la función para agregar objetos
        )
    }
}
