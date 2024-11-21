// ESTA CLASE YA NO SE UTILIZARÁ POR DISEÑO

package com.luispedrolira.foundit.app.presentation.mainFlow.searchNONUSE

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable

@Serializable
data object SearchDestination

fun NavGraphBuilder.searchScreen(){
    composable<SearchDestination> {

    }
}