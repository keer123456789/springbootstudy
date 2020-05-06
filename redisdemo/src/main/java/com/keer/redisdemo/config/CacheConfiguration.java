package com.keer.redisdemo.config;

import com.alibaba.fastjson.parser.ParserConfig;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

/**
 * @BelongsProject: spring-boot-study
 * @BelongsPackage: com.keer.redisdemo.config
 * @Author: keer
 * @CreateTime: 2020-05-06 09:02
 * @Description:
 */

@Configuration
public class CacheConfiguration extends CachingConfigurerSupport {

    @Bean
    public CacheManager cacheManager(RedisConnectionFactory factory) {


        //设置CacheManager的值序列化方式为 fastJsonRedisSerializer,但其实RedisCacheConfiguration默认使用StringRedisSerializer序列化key，
        Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<>(Object.class);
        RedisSerializationContext.SerializationPair<Object> pair = RedisSerializationContext.SerializationPair.fromSerializer(jackson2JsonRedisSerializer);
        RedisCacheConfiguration config=RedisCacheConfiguration.defaultCacheConfig().serializeValuesWith(pair);

        Map<String, RedisCacheConfiguration> configurationMap = new HashMap<>();
        configurationMap.put("c1", config);
        configurationMap.put("c2", config);

        return  RedisCacheManager.builder(factory)
                .initialCacheNames(configurationMap.keySet())
                .cacheDefaults(config)
                .withInitialCacheConfigurations(configurationMap)
                .build();


    }


}
