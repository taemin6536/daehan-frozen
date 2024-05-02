package com.daehan.frozen.userapi.service;

import com.daehan.frozen.userapi.entity.Member;
import com.daehan.frozen.userapi.entity.dto.req.MemberSaveReqDto;
import com.daehan.frozen.userapi.store.UserMapper;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.List;


@Slf4j
@Service
public class UserService {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");

    @Autowired
    public UserMapper userMapper;

    @Operation(summary = "유저 생성", description = "유저 생성")
    public Member createUser(MemberSaveReqDto reqDto) throws Exception {
//        if (userMapper.findByUsername(reqDto.getUsername()).isPresent()) {
//            throw new Exception("이미 존재하는 아이디입니다.");
//        }

        Member member = null;
        try {
            member = new Member();
            member.setUsername(reqDto.getUsername());
            member.setPassword(reqDto.getPassword());
            member.setEmail(reqDto.getEmail());
            member.setNickname(reqDto.getNickname());
            member.setPhoneNumber(reqDto.getPhoneNumber());
            userMapper.insertUser(member);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return member;
    }

    public List<Member> getUsers() {
        log.info(sdf.format(userMapper.getUsers().get(0).getRegDate()));
        return userMapper.getUsers();
    }
}
