package com.ou.dao;

import com.ou.entity.Admin;

public interface AdminDao extends BaseDao{

    Admin getAdminByPassword(String username, String password) throws Exception;
}
