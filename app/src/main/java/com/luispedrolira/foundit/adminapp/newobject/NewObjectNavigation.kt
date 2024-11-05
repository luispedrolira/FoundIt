package com.luispedrolira.foundit.adminapp.newobject

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.luispedrolira.foundit.adminapp.presentation.newobject.NewObjectContent

fun NavGraphBuilder.newObjectNavigation() {
    composable("newObject") {
        NewObjectContent()
    }
}

