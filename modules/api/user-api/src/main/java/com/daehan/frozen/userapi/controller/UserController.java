package com.daehan.frozen.userapi.controller;

import com.daehan.frozen.userapi.entity.Member;
import com.daehan.frozen.userapi.entity.ResultMessage;
import com.daehan.frozen.userapi.entity.dto.req.MemberSaveReqDto;
import com.daehan.frozen.userapi.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@Slf4j
@RestController
public class UserController {

    @Autowired
    public UserService userService;

    @GetMapping("/api/test")
    public String hello(){
        log.info("test");
        return "test success";
    }

    @PostMapping("/api/user/saveMember")
    public ResponseEntity<Object> saveMember(@Valid @RequestBody MemberSaveReqDto reqDto){

        return new ResponseEntity<>(userService.saveMember(reqDto), HttpStatus.OK);
    }

    @GetMapping("/api/user/getUsers")
    public ResponseEntity<List<Member>> getUsers(){
        List<Member> memberList = userService.getUsers();

        return ResponseEntity.status(HttpStatus.OK).body(memberList);
    }
}
