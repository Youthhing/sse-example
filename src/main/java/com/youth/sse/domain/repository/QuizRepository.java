package com.youth.sse.domain.repository;

import com.youth.sse.domain.entity.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizRepository extends JpaRepository<Quiz, Long> {
}
