package io.github.loacq.data.auth

import com.google.firebase.auth.FirebaseUser

interface AuthRepository {
    suspend fun getCurrentUser(): FirebaseUser?
    suspend fun addUserToFirestore()
}
