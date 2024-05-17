package com.daehan.frozen.userapi.entity.dto.res;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class LoginResDto {
    private String username;
    private String roles;
    private String token;

    public static LoginResDto from(String username, String roles, String token) {
        return LoginResDto.builder()
                .username(username)
                .roles(roles)
                .token(token)
                .build();
    }
}
