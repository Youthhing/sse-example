package com.youth.sse.web.dto;

import jakarta.validation.constraints.NotNull;

public record SubmitRequest(
        @NotNull
        Long userId,
        @NotNull
        Long quizId,
        @NotNull
        String answer
) {
}
