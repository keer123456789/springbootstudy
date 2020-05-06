package com.keer.redisdemo.service.impl;

import com.keer.redisdemo.dao.UserDao;
import com.keer.redisdemo.pojo.User;
import com.keer.redisdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @BelongsProject: spring-boot-study
 * @BelongsPackage: com.keer.redisdemo.service.impl
 * @Author: keer
 * @CreateTime: 2020-05-06 09:12
 * @Description:
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;

    @Override
    public User addNewUser(User user) {
        return userDao.save(user);
    }

    @Override
    public User findById(int id) {
        return userDao.findById(id);
    }
}
