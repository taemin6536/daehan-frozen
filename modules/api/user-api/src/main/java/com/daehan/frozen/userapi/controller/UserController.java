package com.daehan.frozen.userapi.controller;

import com.daehan.frozen.userapi.entity.Member;
import com.daehan.frozen.userapi.entity.dto.req.MemberSaveReqDto;
import com.daehan.frozen.userapi.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "User API", description = "유저 API")
@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    public UserService userService;

    @Operation(summary = "테스트 API", description = "테스트 API")
    @GetMapping("/test")
    public String hello(){
        log.info("test");
        return "test success";
    }

    @Operation(summary = "유저 생성", description = "유저 생성")
    @PostMapping("/user/signup")
    public ResponseEntity<Object> signup(@Valid @RequestBody MemberSaveReqDto reqDto, BindingResult result) throws Exception {

        if (result.hasErrors()){
            Map<String, String> errorMap = new HashMap<>();

            for(FieldError error : result.getFieldErrors()) {
                errorMap.put(error.getField(), error.getDefaultMessage());
            }
            return new ResponseEntity<>(errorMap, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(userService.createUser(reqDto), HttpStatus.OK);
    }

    @Operation(summary = "모든 유저 조회", description = "모든 유저 조회")
    @GetMapping("/user/list")
    public ResponseEntity<List<Member>> getUsers(){
        List<Member> memberList = userService.getUsers();

        return ResponseEntity.status(HttpStatus.OK).body(memberList);
    }


    @Operation(summary = "로그인", description = "로그인")
    @PostMapping("/user/login")
    public ResponseEntity<?> login(@RequestBody MemberSaveReqDto reqDto){
        return null;
    }

    @Operation(summary = "로그아웃", description = "로그아웃")
    @PostMapping("/user/logout")
    public ResponseEntity<?> logout(){
        return null;
    }

    @Operation(summary = "프로필 수정", description = "프로필 수정")
    @PutMapping("/user/updateprofile/{id}")
    public ResponseEntity<?> updateprofile(@PathVariable String id, @RequestBody MemberSaveReqDto reqDto){
//        return ResponseEntity.ok(userService.updateProfile(id, reqDto));
        return null;
    }

    @Operation(summary = "비밀번호 변경", description = "비밀번호 변경")
    @PutMapping("/user/changepassword/{id}")
    public ResponseEntity<?> changepassword(@PathVariable String id, @RequestBody MemberSaveReqDto reqDto){
        return null;
    }

    @Operation(summary = "유저 삭제", description = "유저 삭제")
    @DeleteMapping("/user/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable String id){
        return null;
    }

    @Operation(summary = "유저 조회", description = "유저 조회")
    @GetMapping("/user/{id}")
    public ResponseEntity<?> getUser(@PathVariable String id){
        return null;
    }

    @Operation(summary = "유저 프로필 조회", description = "유저 프로필 조회")
    @GetMapping("/user/{id}/profile")
    public ResponseEntity<?> getUserProfile(@PathVariable String id){
        return null;
    }

    @Operation(summary = "유저 권한 조회", description = "유저 권한 조회")
    @GetMapping("/user/{id}/roles")
    public ResponseEntity<?> getUserRoles(@PathVariable String id){
        return null;
    }


}
