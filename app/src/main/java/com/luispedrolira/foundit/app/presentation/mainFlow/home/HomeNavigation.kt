package com.luispedrolira.foundit.app.presentation.mainFlow.home

import kotlinx.serialization.Serializable
@Serializable
sealed class HomeNavigation(val route: String) {
    @Serializable
    object Home : HomeNavigation("homeScreen")

    @Serializable
    data class Search(val query: String = "") : HomeNavigation("searchScreen?query=$query")

}