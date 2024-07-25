package com.youth.sse.domain.service;

import com.youth.sse.domain.entity.Quiz;
import com.youth.sse.domain.entity.Reply;
import com.youth.sse.domain.redis.TicketCountRedisRepository;
import com.youth.sse.domain.repository.QuizRepository;
import com.youth.sse.domain.repository.ReplyRepository;
import com.youth.sse.web.dto.ResultResponse;
import com.youth.sse.web.dto.SubmitRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ReplyService {

    private final ReplyRepository replyRepository;
    private final QuizRepository quizRepository;
    private final TicketCountRedisRepository ticketCountRedisRepository;

    @Transactional
    public ResultResponse submitAnswer(SubmitRequest request) {
        Long ticketNumber = ticketCountRedisRepository.increment(request.quizId());
        Quiz findQuiz = quizRepository.findById(request.quizId()).orElseThrow();

        Reply submitedReply = replyRepository.save(Reply.builder()
                .quiz(findQuiz)
                .ticketNumber(ticketNumber)
                .userId(request.userId())
                .answer(request.answer())
                .isCorrect(request.answer().equals(findQuiz.getAnswer()))
                .build());

        return ResultResponse.from(submitedReply);
    }
}
