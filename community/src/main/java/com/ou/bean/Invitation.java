package com.ou.bean;

import lombok.Data;

import java.util.Date;

@Data
public class Invitation {

    private int id;

    private int communityId;

    private int userId;

    private String title;

    private Date time;

    private String content;
}
