package com.keer.mybatisdemo.pojo;

/**
 * @BelongsProject: spring-boot-study
 * @BelongsPackage: com.keer.mybatisdemo.pojo
 * @Author: keer
 * @CreateTime: 2020-03-08 20:14
 * @Description:
 */
public class People {
    private String name;
    private int id;
    private int age;
    private String address;

    public People() {
    }

    public People(String name, int id, int age, String address) {
        this.name = name;
        this.id = id;
        this.age = age;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "People{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }
}
