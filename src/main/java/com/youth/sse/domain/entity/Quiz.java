package com.youth.sse.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "quiz_id")
    private Long id;

    @Column(name = "quiz_question", nullable = false)
    private String question;

    @Column(name = "quiz_answer", nullable = false)
    private String answer;

    @Column(name = "quiz_status", nullable = false)
    @Enumerated(EnumType.STRING)
    private QuizStatus status;

    @Builder
    public Quiz(String question, String answer) {
        this.question = question;
        this.answer = answer;
        this.status = QuizStatus.CLOSED;
    }

    public void updateStatus(QuizStatus quizStatus) {
        this.status = quizStatus;
    }
}
