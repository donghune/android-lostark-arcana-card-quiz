@file:OptIn(ExperimentalMaterial3Api::class)

package io.github.loacq

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import io.github.loacq.design_system.theme.LostArkTheme
import io.github.loacq.feature.login.loginNavigationRoute
import io.github.loacq.feature.login.loginScreen

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LostArkTheme(useDarkTheme = true) {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LostarkArcanaCardQuizApp()
                }
            }
        }
    }
}

@Composable
fun LostarkArcanaCardQuizApp(modifier: Modifier = Modifier) {
    Scaffold(modifier = modifier) { paddingValue ->
        Surface(modifier = Modifier.background(MaterialTheme.colorScheme.background)) {
            NavHost(
                navController = rememberNavController(),
                startDestination = loginNavigationRoute,
                modifier = modifier.padding(paddingValue),
            ) {
                loginScreen()
            }
        }
    }
}
