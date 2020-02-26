package com.ou.mapper;

import com.ou.bean.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper extends BaseMapper<User> {

    //注册新用户
    int insert(User user);

    User getById(Integer id);

    User getUserByCommentId(Integer commentId);

    //登录用户
    User getUserByPassword(@Param("username") String username, @Param("password") String password);

}
