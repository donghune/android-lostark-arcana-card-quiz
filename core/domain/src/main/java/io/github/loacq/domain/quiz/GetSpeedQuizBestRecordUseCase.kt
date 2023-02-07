package io.github.loacq.domain.quiz

import io.github.loacq.data.quiz.QuizRepository
import io.github.loacq.data.room.SpeedRecord

class GetSpeedQuizBestRecordUseCase(
    private val quizRepository: QuizRepository
) {
    suspend operator fun invoke(): SpeedRecord? {
        return quizRepository.getSpeedQuizRecords().maxByOrNull { it.count }
    }
}
