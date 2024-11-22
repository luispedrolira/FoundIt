package com.luispedrolira.foundit.adminapp.dashboard

import kotlinx.serialization.Serializable

@Serializable
data class Objeto(
    val nombre: String,
    val ubicacion: String,
    val imagenResourceId: Int
)
