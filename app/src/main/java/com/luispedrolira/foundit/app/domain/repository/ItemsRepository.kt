package com.luispedrolira.foundit.app.domain.repository

import com.luispedrolira.foundit.app.domain.model.LostItem

interface ItemsRepository {
    suspend fun addItem(item: LostItem): Boolean
    suspend fun getItems(): List<LostItem>
}