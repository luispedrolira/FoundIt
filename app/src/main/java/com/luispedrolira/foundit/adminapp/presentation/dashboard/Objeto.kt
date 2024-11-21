package com.luispedrolira.foundit.adminapp.presentation.dashboard

import kotlinx.serialization.Serializable

@Serializable
data class Objeto(
    val nombre: String,
    val ubicacion: String,
    val imagenResourceId: Int
)
