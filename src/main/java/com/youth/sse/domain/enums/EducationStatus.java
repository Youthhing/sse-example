package com.youth.sse.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EducationStatus {
    OPEN("교육 진행 "),
    STOP("교육 종료"),
    ;
    private final String description;
}
