package com.daehan.frozen.userapi.jwt;

import com.daehan.frozen.userapi.entity.Member;
import com.daehan.frozen.userapi.store.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class AdminInitailizer implements ApplicationRunner {

    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        userMapper.insertUser(Member.builder()
                .username("admin")
                .password(passwordEncoder.encode("admin"))
                .nickname("admin")
                .email("admin@naver.com")
                .phoneNumber("010-1234-5678")
                .roles("1")
                .build());
    }
}
