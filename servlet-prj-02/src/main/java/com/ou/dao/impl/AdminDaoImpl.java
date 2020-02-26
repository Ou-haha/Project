package com.ou.dao.impl;

import com.ou.dao.AdminDao;
import com.ou.entity.Admin;
import com.ou.utils.BeanHandler;
import com.ou.utils.JdbcTemplate;

public class AdminDaoImpl implements AdminDao {

    @Override
    public Admin getAdminByPassword(String username,String password) throws Exception{
        String sql = "select * from admin where username =? and password =?";
        return (Admin) JdbcTemplate.query(sql,new BeanHandler(Admin.class),username,password);
    }
}
