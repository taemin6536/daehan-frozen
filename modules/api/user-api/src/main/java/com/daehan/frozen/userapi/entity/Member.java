package com.daehan.frozen.userapi.entity;

import lombok.Data;

@Data
public class Member {
    private String id;
    private String name;
    private String passwd;
    private String email;

}
