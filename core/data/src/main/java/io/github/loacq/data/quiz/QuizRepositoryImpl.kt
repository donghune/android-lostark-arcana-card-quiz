package io.github.loacq.data.quiz

import io.github.loacq.data.room.SpeedRecord
import io.github.loacq.data.room.SpeedRecordDao
import io.github.loacq.data.room.TimeRecord
import io.github.loacq.data.room.TimeRecordDao

class QuizRepositoryImpl(
    private val speedRecordDao: SpeedRecordDao,
    private val timeRecordDao: TimeRecordDao
) : QuizRepository {
    override suspend fun getSpeedQuizRecords(): List<SpeedRecord> {
        return speedRecordDao.getAllRecords()
    }

    override suspend fun addSpeedQuizRecord(speedRecord: SpeedRecord) {
        speedRecordDao.insert(speedRecord)
    }

    override suspend fun getTimeQuizRecords(): List<TimeRecord> {
        return timeRecordDao.getAllRecords()
    }

    override suspend fun addTimeQuizRecord(timeRecord: TimeRecord) {
        timeRecordDao.insert(timeRecord)
    }
}
