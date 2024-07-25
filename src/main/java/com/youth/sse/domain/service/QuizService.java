package com.youth.sse.domain.service;

import com.youth.sse.domain.entity.Quiz;
import com.youth.sse.domain.repository.QuizRepository;
import com.youth.sse.web.dto.AddQuizzesRequest;
import com.youth.sse.web.dto.QuizResponse;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class QuizService {

    private final QuizRepository quizRepository;

    @Transactional
    public void uploadQuizzes(AddQuizzesRequest request) {
        quizRepository.saveAll(request.quizzes().stream()
                .map(re -> Quiz.builder()
                        .question(re.question())
                        .answer(re.answer())
                        .build())
                .toList());
    }

    @Transactional(readOnly = true)
    public QuizResponse findQuiz(Long quizId) {
        Quiz findQuiz = quizRepository.findById(quizId).orElseThrow();
        return QuizResponse.from(findQuiz);
    }
}
