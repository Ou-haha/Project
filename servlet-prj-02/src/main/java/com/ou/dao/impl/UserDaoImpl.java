package com.ou.dao.impl;

import com.ou.dao.UserDao;
import com.ou.entity.User;
import com.ou.utils.BeanHandler;
import com.ou.utils.JdbcTemplate;
import sun.security.util.Password;

public class UserDaoImpl implements UserDao {
    @Override
    public User getUserByPassword(String username, String password) throws Exception {
        String sql = "select * from user where username = ? and password = ?";
        return (User) JdbcTemplate.query(sql, new BeanHandler(User.class),username,password);
    }

    @Override
    public int insert(User user) throws Exception {
        String sql = "insert into user(username,password,birthday,email,tel_number) values(?,?,?,?,?)";
        return JdbcTemplate.update(sql,user.getUsername(),user.getPassword(),user.getBirthday(),user.getEmail(),user.getTelNumber());
    }

    @Override
    public int getUserByName(String username) throws Exception {
        String sql = "select * from user where username = ?";
        return JdbcTemplate.queryCount(sql,username);
    }
}

