package com.luispedrolira.foundit.app.missingObject

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

data class MissingObjectState(
    val category: String = "",
    val location: String = "",
    val description: String = ""
)

class MissingObjectViewModel : ViewModel() {

    // Estado actual del objeto perdido
    private val _missingObjectState = MutableStateFlow(MissingObjectState())
    val missingObjectState: StateFlow<MissingObjectState> = _missingObjectState

    // Actualizar los datos del objeto perdido
    fun updateMissingObject(category: String, location: String, description: String) {
        _missingObjectState.value = MissingObjectState(
            category = category,
            location = location,
            description = description
        )
    }
}
