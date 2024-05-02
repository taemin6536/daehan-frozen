package com.daehan.frozen.userapi.entity.dto.req;

import com.daehan.frozen.userapi.entity.Member;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LoginReq {
    private String username;
    private String password;

    public LoginReq() {
    }

    public LoginReq(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public LoginReq(Member member) {
        this.username = member.getUsername();
        this.password = member.getPassword();
    }
}
