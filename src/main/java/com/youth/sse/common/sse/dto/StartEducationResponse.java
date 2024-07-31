package com.youth.sse.common.sse.dto;

import com.youth.sse.domain.enums.EducationStatus;
import lombok.Builder;

@Builder
public record StartEducationResponse(
        Long educationId,
        Long educationNumber,
        EducationStatus status
) {
}
