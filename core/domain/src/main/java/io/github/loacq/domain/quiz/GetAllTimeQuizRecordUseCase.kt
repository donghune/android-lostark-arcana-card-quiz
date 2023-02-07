package io.github.loacq.domain.quiz

import io.github.loacq.data.quiz.QuizRepository
import io.github.loacq.data.room.TimeRecord

class GetAllTimeQuizRecordUseCase(
    private val quizRepository: QuizRepository
) {
    suspend operator fun invoke(): List<TimeRecord> {
        return quizRepository.getTimeQuizRecords()
    }
}
