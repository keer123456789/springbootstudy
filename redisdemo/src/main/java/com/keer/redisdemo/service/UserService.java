package com.keer.redisdemo.service;

import com.keer.redisdemo.pojo.User;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

/**
 * @BelongsProject: spring-boot-study
 * @BelongsPackage: com.keer.redisdemo.service
 * @Author: keer
 * @CreateTime: 2020-05-06 09:11
 * @Description:
 */
@CacheConfig(cacheNames = "c1")
public interface UserService {
    /**
     * 增加新用户
     * @param user
     * @return
     */
    @CachePut(key="#user.id")
    User addNewUser(User user);

    /**
     * 根据id查询用户信息
     * @param id
     * @return
     */
    @Cacheable()
    User findById(int id);
}
