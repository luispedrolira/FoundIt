package com.luispedrolira.foundit.app.presentation.mainFlow.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.firestore.FirebaseFirestore
import com.luispedrolira.foundit.app.domain.model.LostItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await


sealed class HomeUiState {
    object Loading : HomeUiState()
    data class Success(val items: List<LostItem>) : HomeUiState()
    data class Error(val message: String) : HomeUiState()
}

class HomeViewModel : ViewModel() {
    private val _uiState = MutableStateFlow<HomeUiState>(HomeUiState.Loading)
    val uiState: StateFlow<HomeUiState> get() = _uiState

    private val db = FirebaseFirestore.getInstance()
    private val _lostItems = MutableStateFlow<List<LostItem>>(emptyList())
    val lostItems: StateFlow<List<LostItem>> = _lostItems

    init {
        fetchLostItems()
    }

    private fun fetchLostItems() {
        viewModelScope.launch {
            try {
                // Simular una carga de datos (en producción, esto sería una llamada a API o base de datos)
                _uiState.value = HomeUiState.Loading

                val snapshot = db.collection("lost_items").get().await()
                val items = snapshot.documents.mapNotNull { doc ->
                    doc.toObject(LostItem::class.java)?.copy(id = doc.id)
                }
                _lostItems.value = items

                _uiState.value = HomeUiState.Success(items)
            } catch (e: Exception) {
                _uiState.value = HomeUiState.Error("Error al cargar los datos")
            }
        }
    }
}


