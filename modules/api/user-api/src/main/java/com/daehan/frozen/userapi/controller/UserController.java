package com.daehan.frozen.userapi.controller;

import com.daehan.frozen.userapi.entity.Member;
import com.daehan.frozen.userapi.entity.dto.req.MemberSaveReqDto;
import com.daehan.frozen.userapi.service.UserService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    public UserService userService;

    @GetMapping("/api/test")
    public String hello(){
        log.info("test");
        return "test success";
    }

    @PostMapping("/createUser")
    public ResponseEntity<Object> createUser(@Valid @RequestBody MemberSaveReqDto reqDto, BindingResult result){

        if (result.hasErrors()){
            Map<String, String> errorMap = new HashMap<>();

            for(FieldError error : result.getFieldErrors()) {
                errorMap.put(error.getField(), error.getDefaultMessage());
            }
            return new ResponseEntity<>(errorMap, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(userService.createUser(reqDto), HttpStatus.OK);
    }

    @GetMapping("/getUsers")
    public ResponseEntity<List<Member>> getUsers(){
        List<Member> memberList = userService.getUsers();

        return ResponseEntity.status(HttpStatus.OK).body(memberList);
    }
}
