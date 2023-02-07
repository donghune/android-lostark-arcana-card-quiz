@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalLifecycleComposeApi::class)

package io.github.loacq.feature.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DirectionsWalk
import androidx.compose.material.icons.filled.Timer
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.ExperimentalLifecycleComposeApi
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import io.github.loacq.design_system.theme.LostArkTheme
import io.github.loacq.feature.home.component.QuizButton
import java.time.LocalTime
import java.time.format.DateTimeFormatter

@Composable
fun HomeScreenRoute(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    HomeScreen(
        modifier = modifier,
        homeUiState = uiState
    )
}

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    homeUiState: HomeUiState
) {
    Column(modifier = modifier.padding(vertical = 16.dp, horizontal = 16.dp)) {
        QuizButton(
            title = "스피드",
            description = "최대한 빨리 카드를 맞추세요!",
            icon = Icons.Filled.DirectionsWalk,
            recentRecord = homeUiState.speedQuizRecentRecords.toString(),
            bestRecord = homeUiState.speedQuizBestRecords.toString(),
            onClick = {}
        )
        Spacer(modifier = Modifier.height(16.dp))
        QuizButton(
            title = "타임어택",
            description = "최대한 많은 카드를 맞추세요!",
            icon = Icons.Filled.Timer,
            recentRecord = homeUiState.timeQuizRecentRecords.toRecord(),
            bestRecord = homeUiState.timeQuizBestRecords.toRecord(),
            onClick = {}
        )
    }
}

private fun LocalTime.toRecord(): String {
    return if (this == LocalTime.MIN) {
        "기록 없음"
    } else {
        this.format(DateTimeFormatter.ofPattern("mm:ss.AAAA"))
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    LostArkTheme {
        HomeScreen(homeUiState = HomeUiState())
    }
}
