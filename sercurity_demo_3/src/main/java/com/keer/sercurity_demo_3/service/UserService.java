package com.keer.sercurity_demo_3.service;

import com.keer.sercurity_demo_3.entity.User;

/**
 * @BelongsProject: spring-boot-study
 * @BelongsPackage: com.keer.sercurity_demo_3.service
 * @Author: keer
 * @CreateTime: 2020-04-30 15:48
 * @Description:
 */
public interface UserService {
    /**
     * 创建用户信息
     * @param user
     * @return
     */
    User createUser(User user);

    /**
     * 根据用户名查找用户信息
     * @param name
     * @return
     */
    User findUserByName(String name);
}
