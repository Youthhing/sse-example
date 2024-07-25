package com.youth.sse.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum QuizStatus {
    OPEN("문제 풀이가 가능한 상태"),
    CLOSED("문제 풀이가 불가능한 상태")
    ;

    private final String description;
}
