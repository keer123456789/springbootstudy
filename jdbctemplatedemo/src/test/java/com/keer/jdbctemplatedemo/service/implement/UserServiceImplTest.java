package com.keer.jdbctemplatedemo.service.implement;

import com.keer.jdbctemplatedemo.dao.UserDao;
import com.keer.jdbctemplatedemo.pojo.User;
import com.keer.jdbctemplatedemo.pojo.WebResult;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.internal.verification.VerificationModeFactory;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

/**
 * @BelongsProject: spring-boot-study
 * @BelongsPackage: com.keer.jdbctemplatedemo.service.implement
 * @Author: keer
 * @CreateTime: 2020-03-12 15:15
 * @Description:
 */
@RunWith(SpringRunner.class)
public class UserServiceImplTest {
    @InjectMocks
    UserServiceImp userService;

    @Mock
    UserDao userDao;

    @Before
    public void setup(){
        User bob = new User("bob", "123456");
        User alex = new User("alex", "234567");
        User john = new User("john", "345678");

        List<User> allUsers = Arrays.asList(john, bob, alex);

        Mockito.when(userDao.insertUser(bob)).thenReturn(true);

    }


    @Test
    public void testInsertUser(){
        User bob = new User("bob", "123456");
        Mockito.when(userDao.insertUser(bob)).thenReturn(true);
        WebResult found=userService.insertUser(bob);
        Assertions.assertThat(found.getStatus()).isEqualTo(WebResult.SUCCESS);
        Mockito.verify(userDao, VerificationModeFactory.times(1)).insertUser(Mockito.any());
    }
}
