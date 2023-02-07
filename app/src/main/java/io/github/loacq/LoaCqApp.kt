@file:OptIn(ExperimentalMaterial3Api::class)

package io.github.loacq

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import io.github.loacq.component.LoaCqAppBar
import io.github.loacq.component.LoaCqBottomNav
import io.github.loacq.feature.home.homeScreen
import io.github.loacq.feature.home.navigateToHomeScreen
import io.github.loacq.feature.login.loginNavigationRoute
import io.github.loacq.feature.login.loginScreen

@Composable
fun LostarkArcanaCardQuizApp(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    var shouldShowBottomBar by remember { mutableStateOf(false) }
    val navBackStackEntry by navController.currentBackStackEntryAsState()

    shouldShowBottomBar = when (navBackStackEntry?.destination?.route) {
        loginNavigationRoute -> false
        else -> true
    }

    Scaffold(
        modifier = modifier,
        topBar = { if (shouldShowBottomBar) LoaCqAppBar() },
        bottomBar = { if (shouldShowBottomBar) LoaCqBottomNav() }
    ) { paddingValue ->
        Surface(modifier = Modifier.background(MaterialTheme.colorScheme.background)) {
            NavHost(
                navController = navController,
                startDestination = loginNavigationRoute,
                modifier = modifier.padding(paddingValue)
            ) {
                loginScreen(
                    onLoginSuccess = {
                        navController.navigateToHomeScreen()
                    }
                )
                homeScreen()
            }
        }
    }
}
