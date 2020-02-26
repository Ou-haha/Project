package com.ou.service;

import com.ou.entity.Admin;

public interface AdminService {

    Admin login(String username, String password);
}
