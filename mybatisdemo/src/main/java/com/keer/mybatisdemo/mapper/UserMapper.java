package com.keer.mybatisdemo.mapper;

import com.keer.mybatisdemo.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @BelongsProject: spring-boot-study
 * @BelongsPackage: com.keer.mybatisdemo.mapper
 * @Author: keer
 * @CreateTime: 2020-03-08 11:06
 * @Description:
 */
public interface UserMapper {
    /**
     * 获取全部用户信息
     * @return
     */
    List<User> getAll();

    /**
     * 通过id查询用户信息
     * @param id
     * @return
     */
    User getUserInfoByID(String id);

    /**
     * 增加用户信息
     * @param user
     * @return
     */
    int addUserInfo(User user);

    /**
     * 更改用户姓名
     * @param name
     * @param id
     * @return
     */
    int updateUserNameByID(String name,String id);

    /**
     * 根据用户ID删除用户信息
     * @param id
     * @return
     */
    int deleteUserInfoByID(String id);

}
