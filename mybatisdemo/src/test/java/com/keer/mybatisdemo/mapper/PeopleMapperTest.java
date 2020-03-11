package com.keer.mybatisdemo.mapper;

import com.keer.mybatisdemo.pojo.People;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * @BelongsProject: spring-boot-study
 * @BelongsPackage: com.keer.mybatisdemo.mapper
 * @Author: keer
 * @CreateTime: 2020-03-08 20:36
 * @Description:
 */
@RunWith(SpringRunner.class)
@DisplayName("人员接口测试")
@EnableAutoConfiguration
@SpringBootTest
@Transactional
public class PeopleMapperTest {
    @Autowired
    PeopleMapper peopleMapper;

    @Test
    @DisplayName("增加人员信息")
    public void testAddPeopleInfo() {
        People people = new People("keer", 1, 25, "湖北武汉加油！！");
        Assert.assertEquals(1, peopleMapper.addPeopleInfo(people));
    }

    @Test
    @DisplayName("查询全部人员信息")
    public void testGetAllPeopleInfo() {
        System.out.println(peopleMapper.getAllPeopleInfo());
    }

    @Test
    @DisplayName("根据主键id查询人员信息")
    public void testGetPeopleInfoByID() {
        People people = new People("keer", 1, 25, "湖北武汉加油！！");
        Assert.assertEquals(1, peopleMapper.addPeopleInfo(people));
        Assert.assertEquals("keer", peopleMapper.getPeopleInfoByID(1).getName());
    }

    @Test
    @DisplayName("根据id更改人员姓名")
    public void testUpdatePeopleNameByID() {
        People people = new People("keer", 1, 25, "湖北武汉加油！！");
        Assert.assertEquals(1, peopleMapper.addPeopleInfo(people));
        Assert.assertEquals(1, peopleMapper.updatePeopleNameByID("可耳", 1));
    }

    @Test
    @DisplayName("根据id删除人员信息")
    public void testDeletePeopleInfoByID() {
        People people = new People("keer", 1, 25, "湖北武汉加油！！");
        Assert.assertEquals(1, peopleMapper.addPeopleInfo(people));
        Assert.assertEquals(1, peopleMapper.deletePeopleInfoByID(1));
    }
}
