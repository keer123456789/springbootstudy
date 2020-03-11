package com.keer.mybatisdemo.service.implement;

import com.keer.mybatisdemo.mapper.PeopleMapper;
import com.keer.mybatisdemo.pojo.People;
import com.keer.mybatisdemo.pojo.WebResult;
import com.keer.mybatisdemo.service.implement.PeopleServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

/**
 * @BelongsProject: spring-boot-study
 * @BelongsPackage: com.keer.mybatisdemo.service
 * @Author: keer
 * @CreateTime: 2020-03-10 19:51
 * @Description:
 */
@RunWith(SpringRunner.class)
public class PeopleServiceImplTest {


    @InjectMocks
    private PeopleServiceImpl peopleService;

    @Mock
    private PeopleMapper peopleMapper;

    @Before
    public void setup() {
        People bob = new People("bob", 1, 15, "北京");
        People alex = new People("alex", 2, 20, "天津");
        People john = new People("john", 3, 25, "湖北");
        List<People> allPeople = Arrays.asList(john, bob, alex);

        Mockito.when(peopleMapper.getPeopleInfoByID(alex.getId())).thenReturn(alex);
        Mockito.when(peopleMapper.getPeopleInfoByID(-1)).thenReturn(null);

        Mockito.when(peopleMapper.getAllPeopleInfo()).thenReturn(allPeople);

        Mockito.when(peopleMapper.updatePeopleNameByID("alexChange", alex.getId())).thenReturn(1);

        Mockito.when(peopleMapper.deletePeopleInfoByID(john.getId())).thenReturn(1);

    }

    @Test
    @DisplayName(value = "输入正确id查看返回结果是否正确")
    public void whenValidId_thenPeopleShouldBeFound() {
        int alexID = 2;
        WebResult webResult = peopleService.getPeopleInfoByID(alexID);
        People people = (People) webResult.getData();
        Assertions.assertThat(people.getId()).isEqualTo(alexID);
    }


    @Test
    @DisplayName(value = "输入错误ID")
    public void whenInValidName_thenPeopleShouldNotBeFound() {
        int error = -1;
        WebResult webResult = peopleService.getPeopleInfoByID(error);
        Assertions.assertThat(webResult.getStatus()).isEqualTo(WebResult.ERROR);
    }

    @Test
    @DisplayName(value = "获得全部人员信息")
    public void given3People_whenGetAll_thenReturn3Records() {
        People bob = new People("bob", 1, 15, "北京");
        People alex = new People("alex", 2, 20, "天津");
        People john = new People("john", 3, 25, "湖北");

        WebResult webResult = peopleService.getAllPeopleInfo();
        List<People> foundAllPeople = (List<People>) webResult.getData();
        Assertions.assertThat(foundAllPeople).hasSize(3).extracting(People::getName).contains(bob.getName(), alex.getName(), john.getName());
    }

    @Test
    @DisplayName(value = "插入人员信息")
    public void addPeopleInfo_thenReturnSuccess() {
        People bob = new People("bob", 1, 15, "北京");
        Mockito.when(peopleMapper.addPeopleInfo(bob)).thenReturn(1);
        WebResult webResult = peopleService.addPeopleInfo(bob);
        Assertions.assertThat(webResult.getStatus()).isEqualTo(WebResult.SUCCESS);
    }

    @Test
    @DisplayName("根据人员id修改姓名")
    public void updatePeopleName_thenReturnSuccess() {
        String changeName = "alexChange";
        int alexID = 2;
        WebResult webResult = peopleService.updatePeopleNameByID(changeName, alexID);
        Assertions.assertThat(webResult.getStatus()).isEqualTo(WebResult.SUCCESS);
    }

    @Test
    @DisplayName("删除人员信息")
    public void deletePeopleInfo_thenReturnSuccess() {
        int johnID = 3;
        WebResult webResult = peopleService.deletePeopleInfoByID(johnID);
        Assertions.assertThat(webResult.getStatus()).isEqualTo(WebResult.SUCCESS);
    }
}
