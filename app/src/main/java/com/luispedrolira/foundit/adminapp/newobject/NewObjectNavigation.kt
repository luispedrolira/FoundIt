package com.luispedrolira.foundit.adminapp.newobject

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

fun NavGraphBuilder.newObjectNavigation() {
    composable("newObject") {
        NewObjectContent()
    }
}

