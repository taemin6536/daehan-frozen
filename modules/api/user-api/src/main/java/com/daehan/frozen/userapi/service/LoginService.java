package com.daehan.frozen.userapi.service;

import com.daehan.frozen.userapi.entity.Member;
import com.daehan.frozen.userapi.entity.dto.req.LoginReqDto;
import com.daehan.frozen.userapi.entity.dto.res.LoginResDto;
import com.daehan.frozen.userapi.jwt.TokenProvider;
import com.daehan.frozen.userapi.store.UserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.ErrorResponse;

import javax.security.auth.login.LoginException;
import java.text.SimpleDateFormat;

@Slf4j
@Service
@RequiredArgsConstructor
public class LoginService {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");

    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;
    private final TokenProvider tokenProvider;

    @Transactional(readOnly = true)
    public LoginResDto login(LoginReqDto reqDto) throws LoginException {
        Member member = userMapper.findByUsername(reqDto.getUsername());
        if (member == null) {
            throw new LoginException("존재하지 않는 아이디입니다.");
        }
        if (!passwordEncoder.matches(reqDto.getPassword(), member.getPassword())) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }

        String token = tokenProvider.createToken(String.format("%s:%s", member.getUsername(), member.getRoles()));
        return LoginResDto.from(member.getUsername(), member.getRoles(), token);
    }

    @Transactional
    public void logout() {

    }
}
