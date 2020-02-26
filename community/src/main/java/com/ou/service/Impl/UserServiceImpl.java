package com.ou.service.Impl;

import com.ou.bean.User;
import com.ou.mapper.UserMapper;
import com.ou.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public Map<String, Object> login(String username, String password) {

        User user = userMapper.getUserByPassword(username, password);
        Map<String,Object> map = new HashMap<String,Object>();
        if(user != null){

            map.put("success",true);
            map.put("username",user.getUsername());
            map.put("userId", user.getId());
            map.put("message","登录成功");
        }else {
            map.put("success",false);
            map.put("message","用户名或密码错误");
        }
        return map;
    }

    public Map<String, Object> register(User user) {
        Map<String, Object> map = new HashMap<String, Object>();
        if (userMapper.insert(user)>0){
            map.put("success",true);
            map.put("message","注册成功");
        }else {
            map.put("success",false);
            map.put("message","注册失败");
        }
        return map;
    }
}
