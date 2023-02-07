package io.github.loacq.data.module

import android.app.Application
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.github.loacq.data.room.AppDatabase
import io.github.loacq.data.room.SpeedRecordDao
import io.github.loacq.data.room.TimeRecordDao
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RoomModule {

    @Provides
    @Singleton
    fun provideAppDataBase(context: Application): AppDatabase = AppDatabase.getInstance(context)

    @Provides
    @Singleton
    fun provideSpeedRecordDao(appDatabase: AppDatabase): SpeedRecordDao = appDatabase.speedRecordDao()

    @Provides
    @Singleton
    fun provideTimeRecordDao(appDatabase: AppDatabase): TimeRecordDao = appDatabase.timeRecordDao()
}
