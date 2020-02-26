package com.ou.dao;

import com.ou.dao.BaseDao;
import com.ou.entity.User;

import java.util.List;

public interface UserDao extends BaseDao<User> {

    User getUserByPassword(String username,String password) throws Exception;

    @Override
    default int insert(User user) throws Exception {
        return 0;
    }
    int getUserByName(String username) throws Exception;

}
