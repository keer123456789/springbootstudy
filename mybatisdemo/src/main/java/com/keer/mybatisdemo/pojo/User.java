package com.keer.mybatisdemo.pojo;

/**
 * @BelongsProject: spring-boot-study
 * @BelongsPackage: com.keer.mybatisdemo.pojo
 * @Author: keer
 * @CreateTime: 2020-03-08 11:04
 * @Description: 用户对象
 */
public class User {
    private String name;
    private String sex;
    private String id;

    public User() {
    }

    public User(String name, String sex, String id) {
        this.name = name;
        this.sex = sex;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }

    public String getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
