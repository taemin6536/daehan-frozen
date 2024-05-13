package com.daehan.frozen.userapi.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class SwaggerConfig {
    private static final String SECURITY_SCHEME_NAME = "authorization";	// 추가
    private final String REST_API_ROOT = "/api/**";
    private final String REST_API_GROUP = "REST API";

    private final String COMMON_API_ROOT = "/**/*";
    private final String COMMON_API_GROUP = "COMMON API";
    private final String[] COMMON_EXCLUDE_ROOT = {"/api/**/*"};

    @Bean
    public OpenAPI swaggerApi() {
        return new OpenAPI()
                .components(new Components()
                        .addSecuritySchemes(SECURITY_SCHEME_NAME, new SecurityScheme()
                                .name(SECURITY_SCHEME_NAME)
                                .type(SecurityScheme.Type.HTTP)
                                .scheme("bearer")
                                .bearerFormat("JWT")))
                .addSecurityItem(new SecurityRequirement().addList(SECURITY_SCHEME_NAME))
                .info(new Info()
                        .title("냉동 화물 차량 사이트 API swagger 문서")
                        .description("냉동 화물 차량 사이트 API 명세서")
                        .version("1.0.0"));
    }

    @Bean
    public GroupedOpenApi restApi(){

        return GroupedOpenApi.builder()
                .pathsToMatch(REST_API_ROOT)
                .group(REST_API_GROUP)
                .build();
    }

    @Bean
    public GroupedOpenApi commonApi(){

        return GroupedOpenApi.builder()
                .pathsToMatch(COMMON_API_ROOT)
//                .pathsToExclude(COMMON_EXCLUDE_ROOT)
                .group(COMMON_API_GROUP)
                .build();
    }


}
