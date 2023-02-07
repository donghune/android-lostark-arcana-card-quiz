package io.github.loacq.feature.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import io.github.loacq.data.room.diffTime
import io.github.loacq.domain.quiz.GetSpeedQuizBestRecordUseCase
import io.github.loacq.domain.quiz.GetSpeedQuizRecentRecordUseCase
import io.github.loacq.domain.quiz.GetTimeQuizBestRecordUseCase
import io.github.loacq.domain.quiz.GetTimeQuizRecentRecordUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.time.LocalTime
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getTimeQuizRecentRecordUseCase: GetTimeQuizRecentRecordUseCase,
    private val getTimeQuizBestRecordUseCase: GetTimeQuizBestRecordUseCase,
    private val getSpeedQuizRecentRecordUseCase: GetSpeedQuizRecentRecordUseCase,
    private val getSpeedQuizBestRecordUseCase: GetSpeedQuizBestRecordUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState: StateFlow<HomeUiState>
        get() = _uiState

    init {
        fetchGameRecord()
    }

    private fun fetchGameRecord() {
        viewModelScope.launch {
            _uiState.update {
                it.copy(
                    speedQuizRecentRecords = getSpeedQuizRecentRecordUseCase()?.count ?: 0,
                    speedQuizBestRecords = getSpeedQuizBestRecordUseCase()?.count ?: 0,
                    timeQuizRecentRecords = getTimeQuizRecentRecordUseCase()?.diffTime() ?: LocalTime.MIN,
                    timeQuizBestRecords = getTimeQuizBestRecordUseCase()?.diffTime() ?: LocalTime.MIN
                )
            }
        }
    }
}
