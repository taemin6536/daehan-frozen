package com.tae.min.userapi.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user/v1")
@Slf4j
public class UserController {

    @GetMapping("test")
    public String test(){
        log.info("test");
        return "test";
    }
}
