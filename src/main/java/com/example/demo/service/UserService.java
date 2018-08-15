package com.example.demo.service;

import com.example.demo.bean.User;

import java.util.List;
import java.util.Map;

public interface UserService {

    public List<User> queryList(Map<String, String> map);

}
