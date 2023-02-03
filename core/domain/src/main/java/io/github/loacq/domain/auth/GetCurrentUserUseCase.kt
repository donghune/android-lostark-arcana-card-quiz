package io.github.loacq.domain.auth

import com.google.firebase.auth.FirebaseUser
import io.github.loacq.data.auth.AuthRepository
import javax.inject.Inject

class GetCurrentUserUseCase @Inject constructor(
    private val authRepository: AuthRepository
) {
    suspend operator fun invoke(): FirebaseUser? {
        return authRepository.getCurrentUser()
    }
}