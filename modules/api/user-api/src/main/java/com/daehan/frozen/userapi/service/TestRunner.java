package com.daehan.frozen.userapi.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;

//@Deprecated
//@Slf4j
//@Component
//public class TestRunner implements ApplicationRunner {
//
//    @Autowired
//    DataSource dataSource;
//
//    @Autowired
//    JdbcTemplate jdbcTemplate;
//
//    @Override
//    public void run(ApplicationArguments args) throws Exception {
//        // DataSource
//        Connection connection = dataSource.getConnection();
//        log.info("DBCP: " + dataSource.getClass()); // 사용하는 DBCP 타입 확인
//        log.info("Url: " + connection.getMetaData().getURL());
//        log.info("UserName: " + connection.getMetaData().getUserName());
//
//        // JdbcTemplate
//        jdbcTemplate.execute("INSERT INTO MEMBER (username, password, nickname, email, phoneNumber, roles)\n" +
//                "VALUES ('soraa', 'sorsa', 'sdora', 'abc1f234@naver.com', '01022345678', 1)");
//    }
//}
