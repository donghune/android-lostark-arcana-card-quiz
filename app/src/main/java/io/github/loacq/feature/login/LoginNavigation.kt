package io.github.loacq.feature.login

import android.util.Log
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable

const val loginNavigationRoute = "login_screen"

fun NavController.navigateToLoginScreen(navOptions: NavOptions? = null) {
    this.navigate(loginNavigationRoute, navOptions)
}

fun NavGraphBuilder.loginScreen() {
    composable(route = loginNavigationRoute) {
        LoginScreenRoute(
            onLoginSuccess = { Log.d("LoginNavigation", "loginScreen: login success") }
        )
    }
}
