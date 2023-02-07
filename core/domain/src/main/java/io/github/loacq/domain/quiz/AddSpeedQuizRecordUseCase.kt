package io.github.loacq.domain.quiz

import io.github.loacq.data.quiz.QuizRepository
import io.github.loacq.data.room.SpeedRecord

class AddSpeedQuizRecordUseCase(
    private val quizRepository: QuizRepository
) {
    suspend operator fun invoke(speedRecord: SpeedRecord) {
        return quizRepository.addSpeedQuizRecord(speedRecord)
    }
}
