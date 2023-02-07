package io.github.loacq.domain.auth

import com.google.firebase.auth.AuthCredential
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import io.github.loacq.data.auth.AuthRepository
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class SignInFirebaseUseCase @Inject constructor(
    private val auth: FirebaseAuth,
    private val authRepository: AuthRepository
) {
    @Throws(Exception::class)
    suspend operator fun invoke(
        googleCredential: AuthCredential
    ): FirebaseUser? {
        try {
            val authResult = auth.signInWithCredential(googleCredential).await()
            val isNewUser = authResult.additionalUserInfo?.isNewUser ?: false
            if (isNewUser) {
                authRepository.addUserToFirestore()
            }
            return authResult.user
        } catch (e: Exception) {
            throw e
        }
    }
}
