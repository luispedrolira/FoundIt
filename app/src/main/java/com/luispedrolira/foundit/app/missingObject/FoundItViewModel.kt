package com.luispedrolira.foundit.app.missingObject

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.luispedrolira.foundit.app.data.repository.FirebaseItemsRepository
import com.luispedrolira.foundit.app.domain.model.LostItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class FoundItViewModel(private val repository: FirebaseItemsRepository) : ViewModel() {
    private val _items = MutableStateFlow<List<LostItem>>(emptyList())
    val items: StateFlow<List<LostItem>> = _items

    // Saca data de FireStore
    fun fetchItems() {
        viewModelScope.launch {
            _items.value = repository.getItems()
        }
    }

    // Agrega data a FireStore
    fun addItem(item: LostItem) {
        viewModelScope.launch {
            repository.addItem(item)
            fetchItems() // Refresh the list after adding
        }
    }
}