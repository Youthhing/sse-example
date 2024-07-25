package com.youth.sse.web.dto;

import com.youth.sse.domain.entity.Quiz;
import com.youth.sse.domain.repository.QuizRepository;

public record QuizResponse(
        Long quizId,
        String question,
        String answer
) {
    public static QuizResponse from(final Quiz quiz) {
        return new QuizResponse(
                quiz.getId(),
                quiz.getQuestion(),
                quiz.getAnswer()
        );
    }
}
