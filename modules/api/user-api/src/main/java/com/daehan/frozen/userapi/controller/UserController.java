package com.daehan.frozen.userapi.controller;

import com.daehan.frozen.userapi.entity.Member;
import com.daehan.frozen.userapi.entity.ResultMessage;
import com.daehan.frozen.userapi.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@RestController
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
     * @param request
     */
    @PostMapping("/api/user")
    public ResponseEntity<Object> createUser(HttpRequest request){
        ResultMessage resultMessage = new ResultMessage();


        return ResponseEntity.status(HttpStatus.OK).body();
    }

    @GetMapping("/api/user")
    public ResponseEntity<Member> getUser(){
        Member member = userService.getUser();

        return ResponseEntity.status(HttpStatus.OK).body(member);
    }
}
