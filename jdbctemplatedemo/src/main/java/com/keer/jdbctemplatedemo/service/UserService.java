package com.keer.jdbctemplatedemo.service;

import com.keer.jdbctemplatedemo.pojo.User;
import com.keer.jdbctemplatedemo.pojo.WebResult;

/**
 * @BelongsProject: spring-boot-study
 * @BelongsPackage: com.keer.jdbctemplatedemo.Service
 * @Author: keer
 * @CreateTime: 2020-03-04 10:18
 * @Description: 用户操作接口
 */
public interface UserService {
    /**
     * 增加用户信息
     * @param user
     * @return
     */
    WebResult insertUser(User user);

    /**
     * 删除用户名为 userName 的用户信息
     * @param userName
     * @return
     */
    WebResult removeUser(String userName);

    /**
     * 更改用户密码
     * @param user
     * @return
     */
    WebResult updateUserPassword(User user);

    /**
     * 查询全部用户信息
     * @return
     */
    WebResult selectUserInfo();
}
