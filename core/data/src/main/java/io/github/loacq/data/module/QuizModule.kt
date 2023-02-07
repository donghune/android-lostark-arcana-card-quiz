package io.github.loacq.data.module

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.github.loacq.data.quiz.QuizRepository
import io.github.loacq.data.quiz.QuizRepositoryImpl
import io.github.loacq.data.room.SpeedRecordDao
import io.github.loacq.data.room.TimeRecordDao

@Module
@InstallIn(SingletonComponent::class)
class QuizModule {
    @Provides
    fun provideQuizRepository(
        speedRecordDao: SpeedRecordDao,
        timeRecordDao: TimeRecordDao
    ): QuizRepository = QuizRepositoryImpl(
        speedRecordDao = speedRecordDao,
        timeRecordDao = timeRecordDao
    )
}
