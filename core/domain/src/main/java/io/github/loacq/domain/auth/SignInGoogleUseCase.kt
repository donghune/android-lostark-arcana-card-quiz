package io.github.loacq.domain.auth

import com.google.android.gms.auth.api.identity.BeginSignInRequest
import com.google.android.gms.auth.api.identity.BeginSignInResult
import com.google.android.gms.auth.api.identity.SignInClient
import kotlinx.coroutines.tasks.await
import javax.inject.Inject
import javax.inject.Named

class SignInGoogleUseCase @Inject constructor(
    private val oneTapClient: SignInClient,
    @Named("SIGN_IN_REQUEST")
    private var signInRequest: BeginSignInRequest,
    @Named("SIGN_UP_REQUEST")
    private var signUpRequest: BeginSignInRequest
) {
    @Throws(Exception::class)
    suspend operator fun invoke(): BeginSignInResult? {
        return try {
            oneTapClient.beginSignIn(signInRequest).await()
        } catch (e: Exception) {
            try {
                oneTapClient.beginSignIn(signUpRequest).await()
            } catch (e: Exception) {
                throw e
            }
        }
    }
}
