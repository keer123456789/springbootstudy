package com.keer.redisdemo.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @BelongsProject: spring-boot-study
 * @BelongsPackage: com.keer.redisdemo.pojo
 * @Author: keer
 * @CreateTime: 2020-05-06 19:33
 * @Description:
 */
@Entity(name = "student")
public class Student {
    @Id
    private String id;
    @Column(name = "school", nullable = false)
    private String school;
    @Column(name = "classroom", nullable = false)
    private String classroom;

    public Student() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", school='" + school + '\'' +
                ", classRoom='" + classroom + '\'' +
                '}';
    }
}
