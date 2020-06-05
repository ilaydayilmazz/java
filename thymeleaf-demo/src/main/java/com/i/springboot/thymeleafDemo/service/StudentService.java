package com.i.springboot.thymeleafDemo.service;

import com.i.springboot.thymeleafDemo.model.Student;

import java.util.List;

public interface StudentService {

    public List<Student> listAll();

    public Student get(int studentId);

    public Student save(Student student);

    public int delete(int studentId);


}
