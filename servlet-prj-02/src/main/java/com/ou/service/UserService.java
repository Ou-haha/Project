package com.ou.service;

import com.ou.entity.User;
import sun.security.util.Password;

public interface UserService {

    int register(User user);

    User login(String username, String password);

}
