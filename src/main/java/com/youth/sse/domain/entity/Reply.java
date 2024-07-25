package com.youth.sse.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Reply {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reply_id")
    private Long id;

    @Column(name = "ticket_number", nullable = false)
    private Long ticketNumber;

    @Column(name = "reply_answer", nullable = false)
    private String answer;

    @Column(name = "is_correct", nullable = false)
    private Boolean isCorrect;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "quiz_id")
    private Quiz quiz;

    @Column(name = "use_id", nullable = false)
    private Long userId;

    @Builder
    public Reply(Long ticketNumber, Quiz quiz, String answer, Boolean isCorrect, Long userId) {
        this.ticketNumber = ticketNumber;
        this.quiz = quiz;
        this.answer = answer;
        this.isCorrect = isCorrect;
        this.userId = userId;
    }
}
