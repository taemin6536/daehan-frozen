package com.daehan.frozen.userapi.entity.dto.res;

import com.daehan.frozen.userapi.entity.Member;
import com.daehan.frozen.userapi.entity.dto.req.MemberSaveReqDto;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
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

    public static MemberSaveResDto from(Member request) {
        return MemberSaveResDto.builder()
                .username(request.getUsername())
                .nickname(request.getNickname())
                .email(request.getEmail())
                .phoneNumber(request.getPhoneNumber())
                .roles(request.getRoles())
                .build();
    }

}
