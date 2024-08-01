package com.youth.sse.domain.redis;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class JoinCountRedisRepository {

    private static final String KEY_PREFIX = "$EducationCount";
    private final RedisTemplate<String, String> redisTemplate;

    public Long increment(Long id) {
        return redisTemplate.opsForValue()
                .increment(generateKey(id));
    }

    private String generateKey(Long educationId) {
        return KEY_PREFIX + educationId;
    }
}
