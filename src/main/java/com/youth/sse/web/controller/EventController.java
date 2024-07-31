package com.youth.sse.web.controller;

import com.youth.sse.common.sse.SseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.io.IOException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

@Tag(name = "발생 가능한 이벤트 리스트 API")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/events")
public class EventController {

    private final SseService sseService;

    @Operation(summary = "교육 시작 이벤트 구독 API")
    @GetMapping(value = "/education", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public ResponseEntity<SseEmitter> subscribeEducation() throws IOException {
        SseEmitter sseEmitter = new SseEmitter();

        sseEmitter.send(SseEmitter.event()
                .name("education")
                .data("connected")
                .build());

        return ResponseEntity.ok().body(sseService.add(sseEmitter));
    }
}
