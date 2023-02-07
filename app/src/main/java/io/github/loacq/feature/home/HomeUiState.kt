package io.github.loacq.feature.home

import java.time.LocalTime

data class HomeUiState(
    val speedQuizRecentRecords: Int = 0,
    val speedQuizBestRecords: Int = 0,
    val timeQuizRecentRecords: LocalTime = LocalTime.MIN,
    val timeQuizBestRecords: LocalTime = LocalTime.MIN
)
