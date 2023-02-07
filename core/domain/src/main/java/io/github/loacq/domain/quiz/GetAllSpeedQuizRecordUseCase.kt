package io.github.loacq.domain.quiz

import io.github.loacq.data.quiz.QuizRepository
import io.github.loacq.data.room.SpeedRecord

class GetAllSpeedQuizRecordUseCase(
    private val quizRepository: QuizRepository
) {
    suspend operator fun invoke(): List<SpeedRecord> {
        return quizRepository.getSpeedQuizRecords()
    }
}
