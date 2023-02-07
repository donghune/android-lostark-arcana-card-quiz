package io.github.loacq.feature.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.android.gms.auth.api.identity.SignInClient
import com.google.firebase.auth.AuthCredential
import dagger.hilt.android.lifecycle.HiltViewModel
import io.github.loacq.domain.auth.GetCurrentUserUseCase
import io.github.loacq.domain.auth.SignInFirebaseUseCase
import io.github.loacq.domain.auth.SignInGoogleUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val signInGoogle: SignInGoogleUseCase,
    private val signInFirebase: SignInFirebaseUseCase,
    private val getCurrentUser: GetCurrentUserUseCase,
    val oneTapClient: SignInClient
) : ViewModel() {

    private val _uiState = MutableStateFlow(LoginUiState())
    val uiState: StateFlow<LoginUiState>
        get() = _uiState

    init {
        viewModelScope.launch {
            _uiState.update { beforeState ->
                beforeState.copy(user = getCurrentUser())
            }
        }
    }

    fun oneTapSignIn() = viewModelScope.launch {
        kotlin.runCatching {
            _uiState.update { beforeState ->
                beforeState.copy(signInResponse = signInGoogle())
            }
        }.onFailure {
            _uiState.update { beforeState ->
                beforeState.copy(error = it.message)
            }
        }
    }

    fun signInWithGoogle(googleCredential: AuthCredential) = viewModelScope.launch {
        kotlin.runCatching {
            _uiState.update { beforeState ->
                beforeState.copy(user = signInFirebase(googleCredential))
            }
        }.onFailure {
            _uiState.update { beforeState ->
                beforeState.copy(error = it.message)
            }
        }
    }
}
