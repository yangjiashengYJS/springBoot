package com.example.demo.dao;

import com.example.demo.bean.User;

import java.util.List;


public interface UserMapper {

    /**
     * 获取供应商列表
     * 
     * @return
     */
    public List<User> getUser();
}
