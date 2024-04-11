package com.daehan.frozen.userapi.controller;

import com.daehan.frozen.userapi.entity.Member;
import com.daehan.frozen.userapi.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
//@RequestMapping("/api/user/v1")
@Slf4j
public class UserController {

    @Autowired
    public UserService userService;

    @GetMapping("/api/test")
    public String hello(){
        log.info("test");
        return "test success";
    }

    /**
     * 유저 회원 가입
     * @param member
     * @return member
     */
    @GetMapping("/api/user/create")
    public String createUser(Member member){

    }
}
