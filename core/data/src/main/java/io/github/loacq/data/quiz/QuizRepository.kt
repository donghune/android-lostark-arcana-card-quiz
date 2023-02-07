package io.github.loacq.data.quiz

import io.github.loacq.data.room.SpeedRecord
import io.github.loacq.data.room.TimeRecord

interface QuizRepository {
    suspend fun getSpeedQuizRecords(): List<SpeedRecord>
    suspend fun addSpeedQuizRecord(speedRecord: SpeedRecord)

    suspend fun getTimeQuizRecords(): List<TimeRecord>
    suspend fun addTimeQuizRecord(timeRecord: TimeRecord)
}
