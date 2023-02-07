package io.github.loacq.domain.quiz

import io.github.loacq.data.quiz.QuizRepository
import io.github.loacq.data.room.TimeRecord

class GetTimeQuizBestRecordUseCase(
    private val quizRepository: QuizRepository
) {
    suspend operator fun invoke(): TimeRecord? {
        return quizRepository.getTimeQuizRecords().minByOrNull { it.endTime.toNanoOfDay() - it.starTime.toNanoOfDay() }
    }
}
