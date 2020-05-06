package com.keer.sercurity_demo_3.service.impl;

import com.keer.sercurity_demo_3.dao.UserRepository;
import com.keer.sercurity_demo_3.entity.User;
import com.keer.sercurity_demo_3.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.websocket.server.ServerEndpoint;

/**
 * @BelongsProject: spring-boot-study
 * @BelongsPackage: com.keer.sercurity_demo_3.service.impl
 * @Author: keer
 * @CreateTime: 2020-04-30 15:51
 * @Description:
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public User createUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public User findUserByName(String name) {
        return userRepository.findByName(name);
    }
}
