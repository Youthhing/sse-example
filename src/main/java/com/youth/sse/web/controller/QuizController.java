package com.youth.sse.web.controller;

import com.youth.sse.domain.service.QuizService;
import com.youth.sse.web.dto.AddQuizzesRequest;
import com.youth.sse.web.dto.QuizResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/quizzes")
@RequiredArgsConstructor
public class QuizController {

    private final QuizService quizService;

    @PostMapping
    public ResponseEntity<Void> addQuizzes(@RequestBody @Valid AddQuizzesRequest request) {
        quizService.uploadQuizzes(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{quiz-id}")
    public ResponseEntity<QuizResponse> findQuiz(@PathVariable("quiz-id") Long quizId) {
        return ResponseEntity.ok().body(quizService.findQuiz(quizId));
    }
}
