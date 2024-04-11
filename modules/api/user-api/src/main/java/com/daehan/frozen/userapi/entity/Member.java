package com.daehan.frozen.userapi.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Member {
    private String id;
    private String name;
    private String passwd;
    private String email;
    private boolean roles; //0 : 일반유저, 1 : 관리자
    private Date regDate;
}
