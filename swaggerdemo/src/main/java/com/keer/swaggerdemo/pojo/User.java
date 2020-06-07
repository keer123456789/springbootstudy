package com.keer.swaggerdemo.pojo;

/**
 * @BelongsProject: spring-boot-study
 * @BelongsPackage: com.keer.swaggerdemo.pojo
 * @Author: keer
 * @CreateTime: 2020-06-07 16:33
 * @Description:
 */
public class User {

    private String name;
    private int age;

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
