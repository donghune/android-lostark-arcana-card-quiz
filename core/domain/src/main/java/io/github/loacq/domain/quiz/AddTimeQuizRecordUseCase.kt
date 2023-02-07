package io.github.loacq.domain.quiz

import io.github.loacq.data.quiz.QuizRepository
import io.github.loacq.data.room.TimeRecord

class AddTimeQuizRecordUseCase(
    private val quizRepository: QuizRepository
) {
    suspend operator fun invoke(timeRecord: TimeRecord) {
        return quizRepository.addTimeQuizRecord(timeRecord)
    }
}
