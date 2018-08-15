package com.example.demo.controller;

import com.example.demo.bean.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/hello")
public class HelloController {

    @Autowired
    UserService userService;

    @RequestMapping("/index")
    public String index( Map<String,Object> map){
        System.out.println("hello spring boot");
        map.put("hello","Hello  Spring Boot Templates !");

        return "index";
    }

    @RequestMapping("/user")
    public String user( Map<String,Object> map){
        System.out.println("hello spring boot");
        Map<String,String> maps = new HashMap<String,String>();
        maps.put("test","test");
        List<User> userList = userService.queryList(maps);
        map.put("user","Hello  Spring Boot Templates !");
        System.out.println("userList:"+userList);
        map.put("userList",userList);
        return "user";
    }
}
