package com.youth.sse.web.controller;

import com.youth.sse.domain.service.ReplyService;
import com.youth.sse.web.dto.ResultResponse;
import com.youth.sse.web.dto.SubmitRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/replies")
@RequiredArgsConstructor
public class ReplyController {

    private final ReplyService replyService;

    @PostMapping("/submit")
    public ResponseEntity<ResultResponse> submitAnswer(SubmitRequest request){
        return ResponseEntity.ok().body(replyService.submitAnswer(request));
    }
}
