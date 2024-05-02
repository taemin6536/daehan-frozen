package com.daehan.frozen.userapi.jwt;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.security.Key;
import java.util.Date;

@Slf4j
@Component
public class JwtUtils {

    // Java JWT (JSON Web Token) 라이브러리인 JJWT에서 제공하는 API를 사용하여, HS256(HMAC SHA-256) 알고리즘을 사용하는 시크릿 키를 생성

    private static final Key secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    //accessToken 만료시간 설정
    public final static long ACCESS_TOKEN_VALIDATION_SECOND = 1000L*60*60*1; //1시간
    public static final String AUTHORIZATION_HEADER = "Authorization"; //헤더 이름

    //액세스 토큰 생성 메서드
    public String createAccessToken(String member_id, String name){
        System.out.println("createAccessToken");

        // 토큰 만료 시간 설정(access token)
        Date now = new Date();
        Date expiration = new Date(now.getTime()+ ACCESS_TOKEN_VALIDATION_SECOND);

        // JWT 생성 AccessToken 생성하여 반환, member_id를 주체로 함
        return Jwts.builder()
                .setSubject(member_id)
                .claim("name", name)
                .setIssuedAt(now)
                .setExpiration(expiration)
                .signWith(secretKey)
                .compact();
    }

    public boolean validateToken(String token){
        //토큰 파싱 후 발생하는 예외를 캐치하여 문제가 있으면 false, 정상이면 true 반환
        try{
            Jwts.parserBuilder().setSigningKey(secretKey).build().parseClaimsJws(token);
            return true;
        }
        catch (SignatureException e){
            // 서명이 옳지 않을 때
            log.error("잘못된 토큰 서명입니다.");
        }
        catch (ExpiredJwtException e){
            // 토큰이 만료됐을 때
            log.error("만료된 토큰입니다.");
        }
        catch(IllegalArgumentException | MalformedJwtException e){
            // 토큰이 올바르게 구성되지 않았을 때 처리
            log.error("잘못된 토큰입니다.");
        }
        return false;
    }

    // 토큰에서 member_id를 추출하여 반환하는 메소드
    public String getId(String token){
        log.info("getId");

        return Jwts.parserBuilder().setSigningKey(secretKey).build().parseClaimsJws(token).getBody().getSubject();
    }

    // 토큰에서 name을 추출하여 반환하는 메소드
    public String getName(String token){
        log.info("getName");

        return Jwts.parserBuilder().setSigningKey(secretKey).build().parseClaimsJws(token).getBody().get("name").toString();
    }

    // HttpServletRequest에서 Authorization Header를 통해 access token을 추출하는 메서드입니다.
    public String getAccessToken(HttpServletRequest httpServletRequest) {
        String bearerToken = httpServletRequest.getHeader(AUTHORIZATION_HEADER);
        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7); //Bearer 다음의 토큰만 추출
        }
        return null;
    }
}
