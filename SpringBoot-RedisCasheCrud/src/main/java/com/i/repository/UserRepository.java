package com.i.repository;

import com.i.model.User;

import java.util.Map;

public interface UserRepository {

    void save (User user);

    Map<Integer,User> findAll();

    void update(User user);

    void delete(Integer id);

    User findById (Integer id);
}
