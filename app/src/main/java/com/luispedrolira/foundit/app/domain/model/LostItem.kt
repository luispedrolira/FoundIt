package com.luispedrolira.foundit.app.domain.model

data class LostItem(
    val id: String = "",
    val name: String = "",
    val location: String = "",
    val description: String = "",
    val isFound: Boolean = false
)
