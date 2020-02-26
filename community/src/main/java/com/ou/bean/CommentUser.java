package com.ou.bean;


import lombok.Data;

/**
 * 评论包含用户信息
 */

@Data
public class CommentUser extends Comment {

    private String username;
    //回复对象名称
    private String cforUsername;

}
