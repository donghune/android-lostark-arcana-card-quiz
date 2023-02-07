@file:OptIn(ExperimentalLifecycleComposeApi::class)

package io.github.loacq.feature.login

import android.app.Activity.RESULT_OK
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.IntentSenderRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.ExperimentalLifecycleComposeApi
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.google.android.gms.auth.api.identity.BeginSignInResult
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.GoogleAuthProvider.getCredential
import io.github.loacq.R
import io.github.loacq.component.GoogleLoginButton
import io.github.loacq.design_system.theme.LostArkTheme
import kotlinx.coroutines.delay

@Composable
fun LoginScreenRoute(
    modifier: Modifier = Modifier,
    onLoginSuccess: () -> Unit,
    viewModel: LoginViewModel = hiltViewModel()
) {
    val launcher = rememberLauncherForActivityResult(ActivityResultContracts.StartIntentSenderForResult()) { result ->
        if (result.resultCode == RESULT_OK) {
            try {
                val credentials = viewModel.oneTapClient.getSignInCredentialFromIntent(result.data)
                val googleIdToken = credentials.googleIdToken
                val googleCredentials = getCredential(googleIdToken, null)
                viewModel.signInWithGoogle(googleCredentials)
            } catch (it: ApiException) {
                print(it)
            }
        }
    }

    fun launch(signInResult: BeginSignInResult) {
        val intent = IntentSenderRequest.Builder(signInResult.pendingIntent.intentSender).build()
        launcher.launch(intent)
    }

    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    LaunchedEffect(key1 = uiState) {
        Log.d("LoginScreen", "LoginScreenRoute: uiState = $uiState")
    }

    LaunchedEffect(key1 = uiState.signInResponse) {
        uiState.signInResponse?.let { launch(it) }
    }

    LaunchedEffect(key1 = uiState.user) {
        uiState.user?.let {
            delay(1000L)
            onLoginSuccess()
        }
    }

    LoginScreen(
        modifier = modifier,
        isUserAuthenticated = uiState.isLogin,
        onClickLoginButton = viewModel::oneTapSignIn
    )
}

@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    isUserAuthenticated: Boolean = false,
    onClickLoginButton: () -> Unit = {}
) {
    Surface(
        modifier = modifier.background(MaterialTheme.colorScheme.background)
    ) {
        Box(modifier.padding(horizontal = 16.dp)) {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Image(
                    modifier = Modifier.size(52.dp),
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = null
                )
                Spacer(modifier = Modifier.height(48.dp))
                Text(
                    text = stringResource(id = R.string.app_name),
                    style = MaterialTheme.typography.headlineLarge
                )
                Text(
                    text = stringResource(id = R.string.app_description),
                    style = MaterialTheme.typography.bodyLarge
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter)
                    .padding(bottom = 56.dp)
            ) {
                if (isUserAuthenticated.not()) {
                    GoogleLoginButton(
                        modifier = Modifier.fillMaxWidth(),
                        onClickLoginButton = onClickLoginButton
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    LostArkTheme(useDarkTheme = true) {
        LoginScreen(modifier = Modifier.fillMaxSize())
    }
}
