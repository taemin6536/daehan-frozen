package com.daehan.frozen.userapi.entity;

import com.daehan.frozen.userapi.entity.dto.req.MemberSaveReqDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;
import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String nickname;

    @Column(unique = true)
    private String email;

    @Column(nullable = false)
    private String phoneNumber;

    @Column(nullable = false, columnDefinition = "varchar(255) default '0'")
    private String roles; //0 : 일반유저, 1 : 관리자

    private Date regDate;

    public static Member from(MemberSaveReqDto request, PasswordEncoder encoder) {
        return Member.builder()
                .username(request.getUsername())
                .password(encoder.encode(request.getPassword()))
                .username(request.getUsername())
                .email(request.getUsername())
                .phoneNumber(request.getUsername())
                .roles(request.getRoles())
                .build();
    }

//    public void update(MemberUpdateDto request, PasswordEncoder encoder) {
//
//    }
}
