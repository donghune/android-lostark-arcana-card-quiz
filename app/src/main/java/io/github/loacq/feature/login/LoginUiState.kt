package io.github.loacq.feature.login

import com.google.android.gms.auth.api.identity.BeginSignInResult
import com.google.firebase.auth.UserInfo

data class LoginUiState(
    val isLoading: Boolean = false,
    val error: String? = null,
    val signInResponse: BeginSignInResult? = null,
    val singUpResponse: BeginSignInResult? = null,
    val user: UserInfo? = null,
) {
    val isLogin = user != null
}
