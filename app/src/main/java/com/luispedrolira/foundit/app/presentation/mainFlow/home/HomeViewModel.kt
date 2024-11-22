package com.luispedrolira.foundit.app.presentation.mainFlow.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

data class LostItem(
    val title: String,
    val location: String,
    val description: String
)

sealed class HomeUiState {
    object Loading : HomeUiState()
    data class Success(val items: List<LostItem>) : HomeUiState()
    data class Error(val message: String) : HomeUiState()
}

class HomeViewModel : ViewModel() {

    private val _uiState = MutableStateFlow<HomeUiState>(HomeUiState.Loading)
    val uiState: StateFlow<HomeUiState> get() = _uiState

    init {
        fetchLostItems()
    }

    private fun fetchLostItems() {
        viewModelScope.launch {
            try {
                // Simular una carga de datos (en producción, esto sería una llamada a API o base de datos)
                _uiState.value = HomeUiState.Loading
                kotlinx.coroutines.delay(1000) // Simular tiempo de carga

                val items = listOf(
                    LostItem("Mochila negra", "Encontrado en biblioteca 10:30 am", "Descripción de mochila negra"),
                    LostItem("Audífonos Samsung", "Encontrado en cafetería", "Descripción de audífonos"),
                    LostItem("Teléfono plegable", "Encontrado en sala de estudio", "Descripción del teléfono")
                )

                _uiState.value = HomeUiState.Success(items)
            } catch (e: Exception) {
                _uiState.value = HomeUiState.Error("Error al cargar los datos")
            }
        }
    }
}


