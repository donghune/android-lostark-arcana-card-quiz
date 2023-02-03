package io.github.loacq.domain.auth.module

import android.app.Application
import android.content.Context
import com.google.android.gms.auth.api.identity.BeginSignInRequest
import com.google.android.gms.auth.api.identity.Identity
import com.google.android.gms.auth.api.identity.SignInClient
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.FirebaseAuth
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import io.github.loacq.data.R
import io.github.loacq.data.auth.AuthRepository
import io.github.loacq.domain.auth.GetCurrentUserUseCase
import io.github.loacq.domain.auth.SignInFirebaseUseCase
import io.github.loacq.domain.auth.SignInGoogleUseCase
import javax.inject.Named

@Module
@InstallIn(SingletonComponent::class)
object AuthUseCaseModule {

    @Provides
    fun provideGetIsUserFirebaseUseCase(
        authRepository: AuthRepository,
    ): GetCurrentUserUseCase {
        return GetCurrentUserUseCase(
            authRepository = authRepository
        )
    }

    @Provides
    fun provideSignInFirebaseUseCase(
        auth: FirebaseAuth,
        authRepository: AuthRepository,
    ): SignInFirebaseUseCase {
        return SignInFirebaseUseCase(
            auth = auth,
            authRepository = authRepository
        )
    }

    @Provides
    fun provideSignInGoogleUseCase(
        oneTapClient: SignInClient,
        @Named("SIGN_IN_REQUEST")
        signInRequest: BeginSignInRequest,
        @Named("SIGN_UP_REQUEST")
        signUpRequest: BeginSignInRequest,
    ): SignInGoogleUseCase {
        return SignInGoogleUseCase(
            oneTapClient = oneTapClient,
            signInRequest = signInRequest,
            signUpRequest = signUpRequest
        )
    }

    @Provides
    fun provideOneTapClient(
        @ApplicationContext
        context: Context,
    ) = Identity.getSignInClient(context)

    @Provides
    @Named("SIGN_IN_REQUEST")
    fun provideSignInRequest(
        app: Application,
    ) = BeginSignInRequest.builder()
        .setGoogleIdTokenRequestOptions(
            BeginSignInRequest.GoogleIdTokenRequestOptions.builder()
                .setSupported(true)
                .setServerClientId(app.getString(R.string.gcp_clinet_id))
                .setFilterByAuthorizedAccounts(true)
                .build()
        )
        .setAutoSelectEnabled(true)
        .build()

    @Provides
    @Named("SIGN_UP_REQUEST")
    fun provideSignUpRequest(
        app: Application,
    ) = BeginSignInRequest.builder()
        .setGoogleIdTokenRequestOptions(
            BeginSignInRequest.GoogleIdTokenRequestOptions.builder()
                .setSupported(true)
                .setServerClientId(app.getString(R.string.gcp_clinet_id))
                .setFilterByAuthorizedAccounts(false)
                .build()
        )
        .build()

    @Provides
    fun provideGoogleSignInOptions(
        app: Application,
    ) = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
        .requestIdToken(app.getString(R.string.gcp_clinet_id))
        .requestEmail()
        .build()

    @Provides
    fun provideGoogleSignInClient(
        app: Application,
        options: GoogleSignInOptions,
    ) = GoogleSignIn.getClient(app, options)

}