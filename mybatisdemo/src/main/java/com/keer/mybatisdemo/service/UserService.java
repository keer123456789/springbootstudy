package com.keer.mybatisdemo.service;

import com.keer.mybatisdemo.pojo.User;
import com.keer.mybatisdemo.pojo.WebResult;

/**
 * @BelongsProject: spring-boot-study
 * @BelongsPackage: com.keer.mybatisdemo.service
 * @Author: keer
 * @CreateTime: 2020-03-08 17:31
 * @Description: 用户接口
 */
public interface UserService {
    /**
     * 获得所有用户的信息
     *
     * @return
     */
    WebResult getAllUserInfo();

    /**
     * 增加用户信息
     *
     * @param user
     * @return
     */
    WebResult addUserInfo(User user);

    /**
     * 根据id查询用户信息
     *
     * @param id
     * @return
     */
    WebResult getUserInfoByID(String id);

    /**
     * 根据用户id更新用户姓名
     *
     * @param user
     * @return
     */
    WebResult updateUserNameByID(User user);

    /**
     * 根据用户id删除用户信息
     *
     * @param id
     * @return
     */
    WebResult deleteUserInfoByID(String id);
}
