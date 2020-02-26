package com.ou.service.impl;

import com.ou.dao.UserDao;
import com.ou.entity.User;
import com.ou.factory.DaoFactory;
import com.ou.service.UserService;
import sun.security.util.Password;

public class UserServiceImpl implements UserService {

    UserDao userDao = (UserDao) DaoFactory.getDao("UserDao");

    @Override
    public int register(User user){
        try {
            int userByName = userDao.getUserByName(user.getUsername());
            if(userByName >= 1){
                return -1;
            }else{
                return userDao.insert(user);
            }

        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public User login(String username, String password) {
        try {
            return userDao.getUserByPassword(username,password);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
