package com.i.springBootCrudRestDemo.dao;

public class StudentRepositoryCustomImpl implements  StudentRepositoryCustom {

    @Override
    public int getStudentCount() {
        return 7;
    }
}
