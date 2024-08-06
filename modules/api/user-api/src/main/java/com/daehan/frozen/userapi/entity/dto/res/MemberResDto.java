package com.daehan.frozen.userapi.entity.dto.res;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberResDto {
    private Long id;
    private String username;
    private String nickname;
    private String email;
    private String phoneNumber;
    private String roles;

    public MemberResDto(Long id, String username, String nickname, String email, String phoneNumber, String roles) {
        this.id = id;
        this.username = username;
        this.nickname = nickname;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.roles = roles;
    }
    public MemberResDto() {
    }

}
