package com.daehan.frozen.userapi.entity.dto.res;

import com.daehan.frozen.userapi.entity.Member;
import com.daehan.frozen.userapi.entity.dto.req.MemberSaveReqDto;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MemberSaveResDto {
    private Long id;
    private String username;
    private String nickname;
    private String email;
    private String phoneNumber;
    private String roles;

    public MemberSaveResDto(Long id, String username, String nickname, String email, String phoneNumber, String roles) {
        this.id = id;
        this.username = username;
        this.nickname = nickname;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.roles = roles;
    }
    public MemberSaveResDto() {
    }

    public static Member from(Member request) {
        return Member.builder()
                .username(request.getUsername())
                .password(request.getPassword())
                .username(request.getUsername())
                .email(request.getUsername())
                .phoneNumber(request.getUsername())
                .build();
    }

}
