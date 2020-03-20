package com.keer.jdbctemplatedemo.pojo;

/**
 * @BelongsProject: spring-boot-study
 * @BelongsPackage: com.keer.jdbctemplatedemo.POJO
 * @Author: keer
 * @CreateTime: 2020-03-04 10:02
 * @Description: 用户对象
 */
public class User {
    private String name;
    private String password;

    public User() {
    }

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassWord(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", passWord='" + password + '\'' +
                '}';
    }
}
