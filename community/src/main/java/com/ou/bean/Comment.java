package com.ou.bean;

import lombok.Data;

import java.util.Date;

@Data
public class Comment {

    private Integer id;

    private Integer invitationId;

    private Integer userId;
    //楼中评论区的id，等于该条评论的id
    private Integer cinId;
    //回复对象评论的id
    private Integer cforId;

    private Date time;

    private String content;

}
