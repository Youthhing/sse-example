package com.youth.sse.common.sse;

import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitter.DataWithMediaType;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

@Slf4j
@Service
@RequiredArgsConstructor
public class SseService {

    private final List<SseEmitter> sseEmitters = new CopyOnWriteArrayList<>();

    public SseEmitter add(SseEmitter emitter) {
        this.sseEmitters.add(emitter);

        emitter.onCompletion(() -> {
            log.info("---- on completion callback ----");
            this.sseEmitters.remove(emitter);
        });

        emitter.onTimeout(() -> {
            log.info("---- on timeout callback ----");
            emitter.complete();
        });
        return emitter;
    }

    public void send(Set<DataWithMediaType> data) throws IOException {
        for (SseEmitter sseEmitter : this.sseEmitters) {
            sseEmitter.send(data);
            log.info("사용자 전송 : {}", sseEmitters.size());
        }
    }
}
