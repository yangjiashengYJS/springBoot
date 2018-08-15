package com.example.demo.dao;

import com.example.demo.bean.User;

import java.util.List;
import java.util.Map;


public interface UserMapper {

    /**
     * 获取用户列表
     * 
     * @return
     */
    public List<User> getUser(Map<String,String> map);
}
