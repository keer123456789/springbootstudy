package com.keer.mybatisdemo.service.implement;

import com.keer.mybatisdemo.mapper.UserMapper;
import com.keer.mybatisdemo.pojo.User;
import com.keer.mybatisdemo.pojo.WebResult;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.internal.verification.VerificationModeFactory;
import org.mockito.verification.VerificationAfterDelay;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

/**
 * @BelongsProject: spring-boot-study
 * @BelongsPackage: com.keer.mybatisdemo.service.implement
 * @Author: keer
 * @CreateTime: 2020-03-11 12:54
 * @Description:
 */
@RunWith(SpringRunner.class)
public class UserServiceImplTest {
    @InjectMocks
    UserServiceImpl userService;

    @Mock
    UserMapper userMapper;

    @Before
    public void setup() {
        User bob = new User("bob", "男", "1");
        User alex = new User("alex", "女", "2");
        User john = new User("john", "男", "3");
        List<User> allUsers = Arrays.asList(john, bob, alex);

        Mockito.when(userMapper.getUserInfoByID(alex.getId())).thenReturn(alex);
        Mockito.when(userMapper.getUserInfoByID("error")).thenReturn(null);

        Mockito.when(userMapper.getAll()).thenReturn(allUsers);

        Mockito.when(userMapper.updateUserNameByID("alexChange", alex.getId())).thenReturn(1);

        Mockito.when(userMapper.deleteUserInfoByID(john.getId())).thenReturn(1);

    }

    @Test
    @DisplayName(value = "输入正确id查看返回结果是否正确")
    public void whenValidId_thenPeopleShouldBeFound() {
        String alexID = "2";
        WebResult webResult = userService.getUserInfoByID(alexID);
        User found = (User) webResult.getData();
        Assertions.assertThat(found.getId()).isEqualTo(alexID);
        Mockito.verify(userMapper, VerificationModeFactory.times(1)).getUserInfoByID(Mockito.anyString());
    }


    @Test
    @DisplayName(value = "输入错误ID")
    public void whenInValidName_thenPeopleShouldNotBeFound() {
        String errorID = "error";
        WebResult webResult = userService.getUserInfoByID(errorID);
        Assertions.assertThat(webResult.getStatus()).isEqualTo(WebResult.ERROR);
        Mockito.verify(userMapper, VerificationModeFactory.times(1)).getUserInfoByID(Mockito.anyString());
    }

    @Test
    @DisplayName(value = "获得全部人员信息")
    public void given3People_whenGetAll_thenReturn3Records() {
        User bob = new User("bob", "男", "1");
        User alex = new User("alex", "女", "2");
        User john = new User("john", "男", "3");

        WebResult webResult = userService.getAllUserInfo();
        List<User> foundAllPeople = (List<User>) webResult.getData();
        Assertions.assertThat(foundAllPeople).hasSize(3).extracting(User::getName).contains(bob.getName(), alex.getName(), john.getName());
        Mockito.verify(userMapper, VerificationModeFactory.times(1)).getAll();

    }

    @Test
    @DisplayName(value = "插入人员信息")
    public void addPeopleInfo_thenReturnSuccess() {
        User bob = new User("bob", "男", "1");
        Mockito.when(userMapper.addUserInfo(bob)).thenReturn(1);
        WebResult webResult = userService.addUserInfo(bob);
        Assertions.assertThat(webResult.getStatus()).isEqualTo(WebResult.SUCCESS);
        Mockito.verify(userMapper, VerificationModeFactory.times(1)).addUserInfo(Mockito.any());
    }

    @Test
    @DisplayName("根据人员id修改姓名")
    public void updatePeopleName_thenReturnSuccess() {
        String alexID = "2";
        User changeName = new User();
        changeName.setId(alexID);
        changeName.setName("alexChange");
        WebResult webResult = userService.updateUserNameByID(changeName);
        Assertions.assertThat(webResult.getStatus()).isEqualTo(WebResult.SUCCESS);
        Mockito.verify(userMapper, VerificationModeFactory.times(1)).updateUserNameByID(Mockito.anyString(),Mockito.anyString());
    }

    @Test
    @DisplayName("删除人员信息")
    public void deletePeopleInfo_thenReturnSuccess() {
        String johnID = "3";
        WebResult webResult = userService.deleteUserInfoByID(johnID);
        Assertions.assertThat(webResult.getStatus()).isEqualTo(WebResult.SUCCESS);
        Mockito.verify(userMapper, VerificationModeFactory.times(1)).deleteUserInfoByID(Mockito.anyString());
    }

}
