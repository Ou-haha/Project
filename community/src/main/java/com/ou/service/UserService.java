package com.ou.service;

import com.ou.bean.User;

import java.util.Map;

public interface UserService {

    Map<String, Object> login(String username, String password);

    Map<String, Object> register(User user);
}
