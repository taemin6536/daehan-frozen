package com.daehan.frozen.userapi.service;

import com.daehan.frozen.userapi.entity.Member;
import com.daehan.frozen.userapi.entity.dto.req.LoginReqDto;
import com.daehan.frozen.userapi.entity.dto.req.MemberSaveReqDto;
import com.daehan.frozen.userapi.entity.dto.res.LoginResDto;
import com.daehan.frozen.userapi.entity.dto.res.MemberResDto;
import com.daehan.frozen.userapi.entity.dto.res.MemberSaveResDto;
import com.daehan.frozen.userapi.store.UserMapper;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");

    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    @Operation(summary = "유저 생성", description = "유저 생성")
    public MemberSaveResDto createUser(@NotNull MemberSaveReqDto reqDto) {
//        if (userMapper.findByUsername(reqDto.getUsername()).isPresent()) {
//            throw new Exception("이미 존재하는 아이디입니다.");
//        }
        Member member = Member.from(reqDto, passwordEncoder);
//        System.out.println(member);
        try {
            userMapper.insertUser(member);

        } catch (DataIntegrityViolationException e) {
            e.printStackTrace();
            throw new IllegalArgumentException("이미 존재하는 아이디입니다");
        }

        return MemberSaveResDto.from(member);
    }

    public List<MemberResDto> getUsers() {
//        log.info(sdf.format(userMapper.getUsers().get(0).getRegDate()));
        List<Member> users = userMapper.getUsers();
        List<MemberResDto> memberResDtos = new ArrayList<>();

        for (Member user : users) {
            MemberResDto memberResDto = new MemberResDto();
            memberResDto.setId(user.getId());
            memberResDto.setUsername(user.getUsername());
            memberResDto.setNickname(user.getNickname());
            memberResDto.setEmail(user.getEmail());
            memberResDto.setPhoneNumber(user.getPhoneNumber());
            memberResDto.setRoles(user.getRoles());
            memberResDtos.add(memberResDto);
        }
        return memberResDtos;
    }

//    @Transactional(readOnly = true)
//    public LoginResDto login(LoginReqDto request) {
//        Member member = userMapper.findByUsername(request.getUsername());
//        if (member == null) {
//            throw new IllegalArgumentException("존재하지 않는 아이디입니다.");
//        }
//        if (!passwordEncoder.matches(request.getPassword(), member.getPassword())) {
//            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
//        }
//
//        return LoginResDto.from(member.getUsername(), member.getRoles());
//    }
}
