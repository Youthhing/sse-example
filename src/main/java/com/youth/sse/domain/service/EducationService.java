package com.youth.sse.domain.service;

import com.youth.sse.common.sse.SseService;
import com.youth.sse.common.sse.dto.StartEducationResponse;
import com.youth.sse.domain.entity.Education;
import com.youth.sse.domain.enums.EducationStatus;
import com.youth.sse.domain.repository.EducationRepository;
import com.youth.sse.web.dto.AddEducationRequest;
import java.io.IOException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

@Service
@RequiredArgsConstructor
public class EducationService {

    private static final String START_EDUCATION = "EducationOpen";
    private final EducationRepository educationRepository;
    private final SseService sseService;
    @Transactional
    public void addEducation(AddEducationRequest request) {
        educationRepository.save(Education.builder()
                .status(EducationStatus.STOP)
                .number(request.number())
                .build());
    }

    @Transactional
    public void open(final Long educationId) throws IOException {
        Education findEducation = educationRepository.findById(educationId)
                                .orElseThrow();

        findEducation.updateStatus(EducationStatus.OPEN);

        sseService.send(SseEmitter.event()
                .name(START_EDUCATION)
                .data(StartEducationResponse.builder()
                        .educationId(findEducation.getId())
                        .educationNumber(findEducation.getNumber())
                        .status(findEducation.getStatus())
                        .build())
                .build());
    }
}
