package com.i.springBootCrudRestDemo.dao;

import com.i.springBootCrudRestDemo.model.Student;

import java.util.List;

public interface StudentDao {

    public List<Student> queryAll();

    public Student queryById(int studentId);

    public Student save(Student student);

    public int delete(int studentId);

}
