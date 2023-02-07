package io.github.loacq.data.auth

import com.google.firebase.auth.FirebaseUser
import com.google.firebase.firestore.FieldValue.serverTimestamp

fun FirebaseUser.toUser() = mapOf(
    "displayName" to displayName,
    "email" to email,
    "photoUrl" to photoUrl?.toString(),
    "createAT" to serverTimestamp()
)
