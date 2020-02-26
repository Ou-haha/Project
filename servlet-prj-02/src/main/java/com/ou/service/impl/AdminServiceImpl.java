package com.ou.service.impl;

import com.ou.dao.AdminDao;
import com.ou.entity.Admin;
import com.ou.factory.DaoFactory;
import com.ou.service.AdminService;

public class AdminServiceImpl implements AdminService {

    private AdminDao adminDao = (AdminDao) DaoFactory.getDao("AdminDao");
    @Override
    public Admin login(String username, String password){

        try {
            return adminDao.getAdminByPassword(username, password);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
