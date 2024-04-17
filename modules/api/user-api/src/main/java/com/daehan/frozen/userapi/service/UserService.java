package com.daehan.frozen.userapi.service;

import com.daehan.frozen.userapi.entity.Member;
import com.daehan.frozen.userapi.entity.dto.req.MemberSaveReqDto;
import com.daehan.frozen.userapi.store.UserMapper;
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

    public Member createUser(MemberSaveReqDto reqDto) {
        return null;
    }

    public List<Member> getUsers() {
        log.info(sdf.format(userMapper.getUsers().get(0).getRegDate()));
        return userMapper.getUsers();
    }
}
