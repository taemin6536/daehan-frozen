package com.daehan.frozen.userapi.entity.dto.req;

import com.daehan.frozen.userapi.entity.Member;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberSaveReqDto {


    @NotEmpty(message = "유저아이디 : {invalid.NotEmpty}")
    private String username;

    @NotEmpty(message = "패스워드 : {invalid.NotEmpty}")
    private String password;

    @NotEmpty(message = "닉네임 : {invalid.NotEmpty}")
    private String nickname;

    @Email(message = "이메일 형식이어야합니다.")
    @NotEmpty(message = "이메일 : {invalid.NotEmpty}")
    private String email;

    @NotEmpty(message = "전화번호 : {invalid.NotEmpty}")
    private String phoneNumber;

    private String roles;

    //TODO 이메일 인증 적용 할 때 사용
//    @NotEmpty(message = "인증정보 : 필수값입니다.")
//    private Boolean isUsernameValid;

//    public Member toEntity(PasswordEncoder passwordEncoder){
//        return Member
//                .builder()
//                .username(username)
//                .password(passwordEncoder.encode(password))
//                .nickname(nickname)
//                .email(email)
//                .phoneNumber(phoneNumber)
//                .roles("0") //TODO HashSet , enum 클래스로 바꾸기
//                .build();
//    }


}
