package com.youth.sse.web.controller;

import com.youth.sse.domain.service.EducationService;
import com.youth.sse.web.dto.AddEducationRequest;
import com.youth.sse.web.dto.OpenEducationRequest;
import java.io.IOException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/educations")
@RequiredArgsConstructor
public class EducationController {

    private final EducationService educationService;

    @PostMapping
    public ResponseEntity<Void> addEducation(@RequestBody AddEducationRequest request) {
        educationService.addEducation(request);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/open")
    public ResponseEntity<Void> openEducation(@RequestBody OpenEducationRequest request) throws IOException {
        educationService.open(request.educationId());
        return ResponseEntity.ok().build();
    }
}
