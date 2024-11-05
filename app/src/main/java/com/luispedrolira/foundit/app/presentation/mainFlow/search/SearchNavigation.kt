package com.luispedrolira.foundit.app.presentation.mainFlow.search

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable

@Serializable
data object SearchDestination

fun NavGraphBuilder.searchScreen(){
    composable<SearchDestination> {

    }
}