package com.keer.jpa_demo.service;

import com.keer.jpa_demo.pojo.User;
import com.keer.jpa_demo.pojo.WebResult;

import java.util.List;

/**
 * @BelongsProject: spring-boot-study
 * @BelongsPackage: com.keer.jpa_demo.service
 * @Author: keer
 * @CreateTime: 2020-04-22 15:18
 * @Description:
 */
public interface UserService {
    /**
     * 增加user信息在数据库中
     *
     * @param user
     * @return
     */
    WebResult addUser(User user);

    /**
     * 修改用户信息
     *
     * @param user
     * @return
     */
    WebResult updateUser(User user);

    /**
     * 批量增加用户信息
     *
     * @param list
     * @return
     */
    WebResult addUsers(List list);

    /**
     * 删除用户信息
     *
     * @param user
     * @return
     */
    WebResult removeUser(User user);

    /**
     * 根据用户id修改用户姓名
     *
     * @param name
     * @param id
     * @return
     */
    WebResult updateUserNameById(String name, int id);

    /**
     * 查询所有用户
     * @return
     */
    WebResult selectAllUsers();
}
