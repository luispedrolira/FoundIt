package com.luispedrolira.foundit.app.data.repository

import com.luispedrolira.foundit.app.domain.repository.LoginRepository

class FirebaseLoginRepository(): LoginRepository {
    override suspend fun login(email: String, password: String): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun createUser(email: String, password: String): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun isUserLoggedIn(): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun logout() {
        TODO("Not yet implemented")
    }
}