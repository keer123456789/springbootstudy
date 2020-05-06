package com.keer.sercurity_demo_3.service.impl;

import com.keer.sercurity_demo_3.entity.User;
import com.keer.sercurity_demo_3.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: spring-boot-study
 * @BelongsPackage: com.keer.sercurity_demo_3.service.impl
 * @Author: keer
 * @CreateTime: 2020-04-30 16:16
 * @Description:
 */
@Component
public class MyUserDetailsServiceImpl implements UserDetailsService {
    protected final Logger logger= LoggerFactory.getLogger(this.getClass());

    @Autowired
    UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        logger.info("loadUserByUsername->username={}", username);
        User user = userService.findUserByName(username);
        if(user==null){
            logger.error("用户不存在");
        }
        List<GrantedAuthority> authorities = new ArrayList<>();
        org.springframework.security.core.userdetails.User userDetails = new org.springframework.security.core.userdetails.User(user.getName(),user.getPassword(),authorities);

        return userDetails;
    }
}
