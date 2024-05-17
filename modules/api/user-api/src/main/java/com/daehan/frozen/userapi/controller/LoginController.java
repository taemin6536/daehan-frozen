package com.daehan.frozen.userapi.controller;

import com.daehan.frozen.userapi.entity.ApiResponse;
import com.daehan.frozen.userapi.entity.dto.req.LoginReqDto;
import com.daehan.frozen.userapi.entity.dto.req.MemberSaveReqDto;
import com.daehan.frozen.userapi.entity.dto.res.LoginResDto;
import com.daehan.frozen.userapi.service.LoginService;
import com.daehan.frozen.userapi.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.security.auth.login.LoginException;

@Slf4j
@Tag(name = "Login API", description = "로그인 API")
@RestController
@RequestMapping("/api")
public class LoginController {
    @Autowired
    public LoginService loginService;

    @Operation(summary = "로그인", description = "로그인")
    @PostMapping("/user/login")
    public ApiResponse<LoginResDto> login(@RequestBody LoginReqDto reqDto) throws LoginException {
//        try{
            return ApiResponse.createSuccess(loginService.login(reqDto));
//        }catch (LoginException e){
//            return (ApiResponse<LoginResDto>) ApiResponse.createError(e.getMessage());
//        }
    }

    @Operation(summary = "로그아웃", description = "로그아웃")
    @PostMapping("/user/logout")
    public ResponseEntity<?> logout(){
        return null;
    }
}
