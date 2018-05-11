package com.example.demo.controller;

import com.example.demo.bean.User;
import com.example.demo.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/hello")
public class HelloController {
    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/index")
    public String index( Map<String,Object> map){
        System.out.println("hello spring boot");
        map.put("hello","Hello  Spring Boot Templates !");

        return "index";
    }

    @RequestMapping("/user")
    public String user( Map<String,Object> map){
        System.out.println("hello spring boot");
        List<User> userList = userMapper.getUser();
        map.put("user","Hello  Spring Boot Templates !");
        System.out.println("userList:"+userList);
        map.put("userList",userList);
        return "user";
    }
}
