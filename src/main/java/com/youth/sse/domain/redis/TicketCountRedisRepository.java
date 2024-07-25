package com.youth.sse.domain.redis;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TicketCountRedisRepository {

    private static final String KEY_PREFIX = "$ticket_for";
    private final RedisTemplate<String , ?> redisTemplate;

    public Long increment(Long quizId) {
        return redisTemplate.opsForValue()
                .increment(generateKey(quizId));
    }

    private String generateKey(Long quizId) {
        return KEY_PREFIX + quizId;
    }
}
