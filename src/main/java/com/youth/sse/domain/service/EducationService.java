package com.youth.sse.domain.service;

import com.youth.sse.common.sse.SseService;
import com.youth.sse.domain.entity.Education;
import com.youth.sse.domain.enums.EducationStatus;
import com.youth.sse.domain.repository.EducationRepository;
import com.youth.sse.web.dto.AddEducationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class EducationService {

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
    public void open(final Long educationId) {
        Education findEducation = educationRepository.findById(educationId)
                                .orElseThrow();

        findEducation.updateStatus(EducationStatus.OPEN);
    }
}
