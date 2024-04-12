package com.daehan.frozen.userapi.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String name;
    private String passwd;
    @Column(unique = true)
    private String email;
    private boolean roles; //0 : 일반유저, 1 : 관리자
    private Date regDate;
}
