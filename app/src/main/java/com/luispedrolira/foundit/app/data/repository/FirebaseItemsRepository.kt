package com.luispedrolira.foundit.app.data.repository

import com.luispedrolira.foundit.app.domain.model.LostItem
import com.luispedrolira.foundit.app.domain.repository.ItemsRepository
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await

class FirebaseItemsRepository(): ItemsRepository {

    private val db = FirebaseFirestore.getInstance()

    override suspend fun addItem(item: LostItem): Boolean {
        return try {
            db.collection("items")
                .add(item)
                .await() // Use coroutines to await the result
            true
        } catch (e: Exception) {
            e.printStackTrace()
            false
        }
    }

    override suspend fun getItems(): List<LostItem> {
        return try {
            db.collection("items")
                .get()
                .await()
                .documents
                .mapNotNull { it.toObject(LostItem::class.java) }
        } catch (e: Exception) {
            e.printStackTrace()
            emptyList()
        }
    }
}