package com.keer.redisdemo.dao;

import com.keer.redisdemo.pojo.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @BelongsProject: spring-boot-study
 * @BelongsPackage: com.keer.redisdemo.dao
 * @Author: keer
 * @CreateTime: 2020-05-06 09:15
 * @Description:
 */
@Repository
public interface UserDao extends CrudRepository<User, Integer> {
    /**
     * 根据id查找用户id
     * @param id
     * @return
     */
    User findById(int id);
}
