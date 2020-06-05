package com.i.springBootCrudRestDemo.dao;

import com.i.springBootCrudRestDemo.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Integer> , StudentRepositoryCustom {




}
