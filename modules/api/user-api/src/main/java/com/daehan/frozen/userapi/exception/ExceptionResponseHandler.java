package com.daehan.frozen.userapi.exception;

import com.daehan.frozen.userapi.entity.ApiResponse;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.security.SignatureException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionResponseHandler {

    // 아래 내용 모두 추가
    @ExceptionHandler(SignatureException.class)
    public ResponseEntity<ApiResponse> handleSignatureException() {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(ApiResponse.createError("토큰이 유효하지 않습니다."));
    }

    @ExceptionHandler(MalformedJwtException.class)
    public ResponseEntity<ApiResponse> handleMalformedJwtException() {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(ApiResponse.createError("올바르지 않은 토큰입니다."));
    }

    @ExceptionHandler(ExpiredJwtException.class)
    public ResponseEntity<ApiResponse> handleExpiredJwtException() {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(ApiResponse.createError("토큰이 만료되었습니다. 다시 로그인해주세요."));
    }
}
