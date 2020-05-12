package com.keer.redistemplatedemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * @BelongsProject: spring-boot-study
 * @BelongsPackage: com.keer.redistemplatedemo
 * @Author: keer
 * @CreateTime: 2020-05-07 15:14
 * @Description:
 */

@Component
@CacheConfig(cacheNames = "c1")
public class RedisUtil {
    @Autowired
    RedisTemplate redisTemplate;

    public boolean save(String key, Object value) {
        try {
            redisTemplate.opsForValue().set(key, value);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
