package io.github.loacq.domain.quiz.module

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.github.loacq.data.quiz.QuizRepository
import io.github.loacq.domain.quiz.*

@Module
@InstallIn(SingletonComponent::class)
class QuizUseCaseModule {

    @Provides
    fun provideGetSpeedQuizRecentRecordUseCase(
        quizRepository: QuizRepository
    ): GetSpeedQuizRecentRecordUseCase {
        return GetSpeedQuizRecentRecordUseCase(quizRepository)
    }

    @Provides
    fun provideGetSpeedQuizBestRecordUseCase(
        quizRepository: QuizRepository
    ): GetSpeedQuizBestRecordUseCase {
        return GetSpeedQuizBestRecordUseCase(quizRepository)
    }

    @Provides
    fun provideGetAllSpeedQuizRecordUseCase(
        quizRepository: QuizRepository
    ): GetAllSpeedQuizRecordUseCase {
        return GetAllSpeedQuizRecordUseCase(quizRepository)
    }

    @Provides
    fun provideAddSpeedQuizRecordUseCase(
        quizRepository: QuizRepository
    ): AddSpeedQuizRecordUseCase {
        return AddSpeedQuizRecordUseCase(quizRepository)
    }

    @Provides
    fun provideGetTimeQuizRecentRecordUseCase(
        quizRepository: QuizRepository
    ): GetTimeQuizRecentRecordUseCase {
        return GetTimeQuizRecentRecordUseCase(quizRepository)
    }

    @Provides
    fun provideGetTimeQuizBestRecordUseCase(
        quizRepository: QuizRepository
    ): GetTimeQuizBestRecordUseCase {
        return GetTimeQuizBestRecordUseCase(quizRepository)
    }

    @Provides
    fun provideGetAllTimeQuizRecordUseCase(
        quizRepository: QuizRepository
    ): GetAllTimeQuizRecordUseCase {
        return GetAllTimeQuizRecordUseCase(quizRepository)
    }

    @Provides
    fun provideAddTimeQuizRecordUseCase(
        quizRepository: QuizRepository
    ): AddTimeQuizRecordUseCase {
        return AddTimeQuizRecordUseCase(quizRepository)
    }
}
