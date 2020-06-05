package com.i.springBootCrudRestDemo.dao;

import com.i.springBootCrudRestDemo.model.Kurs;
import com.i.springBootCrudRestDemo.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource (path = "course")
public interface KursRepository extends JpaRepository<Kurs,Integer>  {




}
