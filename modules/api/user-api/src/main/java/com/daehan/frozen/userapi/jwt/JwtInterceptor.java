package com.daehan.frozen.userapi.jwt;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Slf4j
@Component
public class JwtInterceptor implements HandlerInterceptor{
    //인터셉터는 요청이 들어왔을 때, 컨트롤러에 도달하기 전에 가로채는 역할을 한다.
    //인터셉터를 사용하면, 컨트롤러에 도달하기 전에 공통적인 전처리 작업을 할 수 있다.
    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private JwtInterceptor(JwtUtils jwtUtils){
        this.jwtUtils = jwtUtils;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("인터셉터 동작");
        String uri = request.getRequestURI();
        log.info("uri : " + uri);

        //토큰 받기
        // 요청이 들어오면 실행되는 메서드
        String accessToken = jwtUtils.getAccessToken(request);
        log.info("accessToken : " + accessToken);
        //로깅용 URI
        String requestURI = request.getRequestURI();

        //비회원일 때 (토큰이 없을 때)
        if(accessToken == null){
            log.info("토큰이 없습니다.");
//            response.sendRedirect("/user/login");
            return false;
        }else{
            log.info("토큰이 있습니다.");
            //토큰 검증
            if (jwtUtils.validateToken(accessToken)){
                log.info("유효한 토큰 정보입니다. URI : {}", requestURI);
                return true;
            }else{
                log.info("유효하지 않은 jwt 토큰입니다. uri : {}", requestURI);
                return false;
            }
        }
    }
}
