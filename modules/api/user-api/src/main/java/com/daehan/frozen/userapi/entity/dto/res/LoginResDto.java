package com.daehan.frozen.userapi.entity.dto.res;

import lombok.Builder;


@Builder
public class LoginResDto {
    private String username;
    private String roles;

    public static LoginResDto from(String username, String roles) {
        return LoginResDto.builder()
                .username(username)
                .roles(roles)
                .build();
    }
}
