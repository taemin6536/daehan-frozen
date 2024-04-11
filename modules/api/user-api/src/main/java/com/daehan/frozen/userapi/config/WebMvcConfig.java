package com.daehan.frozen.userapi.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry){
        registry.addMapping("/**") // CORS를 적용할 엔드포인트 경로
                .allowedOrigins("*") // 모든 도메인에서의 요청 허용
                .allowedMethods("GET", "POST", "PUT", "DELETE") // 허용된 HTTP 메소드
                .allowedHeaders("*"); // 요청 헤더에서 허용할 내용
//        registry.addMapping("/**")
//                .allowedOrigins("http://localhost:3000")
//                .allowedMethods("OPTIONS","GET","POST","PUT","DELETE");
    }
}
