package com.i.springboot.thymeleafDemo.model;

public class Student {
    String firstName;
    String lastName;
    Integer studentId;

    public Student(String firstName, String lastName, Integer studentId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentId = studentId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Integer getStudentId() {
        return studentId;
    }
}
