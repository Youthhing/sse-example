package com.youth.sse.web.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import java.util.List;

public record AddQuizzesRequest(
        @Valid
        @NotNull
        List<QuizRequest> quizzes
) {

    public record QuizRequest(
            @NotNull
            String question,
            @NotNull
            String answer
    ) {
    }
}
