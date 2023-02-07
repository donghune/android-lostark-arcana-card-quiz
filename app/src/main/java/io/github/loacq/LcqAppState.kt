package io.github.loacq

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import com.google.firebase.auth.FirebaseUser

@Composable
fun rememberLcqAppState(firebaseUser: FirebaseUser?): LcqAppState {
    return remember(firebaseUser) {
        LcqAppState(firebaseUser)
    }
}

@Stable
class LcqAppState(
    val firebaseUser: FirebaseUser?
) {
    val isLogin = firebaseUser != null
}
