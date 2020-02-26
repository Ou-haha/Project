package com.ou.bean;

import lombok.Data;

import java.util.Date;

@Data
public class User {

    private Integer id;

    private String username;

    private String password;

    private String email;

    private String address;

    private Date birthday;

    private String telNumber;

    private String photoUrl;


}
