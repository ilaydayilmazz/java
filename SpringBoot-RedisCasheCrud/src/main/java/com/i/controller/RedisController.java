package com.i.controller;

import com.i.model.User;
import com.i.repository.UserRepository;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/redis/user")
public class RedisController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/all")
    public Map<Integer, User> all(){
        return userRepository.findAll();
    }
    @GetMapping("/add/{id}/{name}")
    public User add(@PathVariable("id") Integer id, @PathVariable("name") String name){

        userRepository.save(new User(id,name));
        return userRepository.findById(id);
    }
    @GetMapping("/update/{id}/{name}")
    public User update(@PathVariable( "id") Integer id, @PathVariable("name") String name){
        userRepository.update(new User(id,name));
        return userRepository.findById(id);
    }
    @GetMapping("/delete/{id}")
    public Map<Integer,User> delete(@PathVariable("id") Integer id){
        userRepository.delete(id);
        return all();
    }
    @GetMapping("/{id}")
    public User getById(@PathVariable("id") Integer id){
        return userRepository.findById(id);
    }

}
