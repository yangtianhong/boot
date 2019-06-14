package com.tian.boot.web.controller;


import com.tian.boot.common.model.User;
import com.tian.boot.one.mapper.OneUserMapper;
import com.tian.boot.one.mapper.OneUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class IndexController {
    @Autowired
    private OneUserMapper oneUserMapper;


    @GetMapping("simple/{id}")
    public User findById(@PathVariable Integer id){
        System.out.println("aaaaaaaaaaa");
        User user = oneUserMapper.selectByPrimaryKey(id);
        //return this.userRepository.findById(id);
        return user;
    }

}
