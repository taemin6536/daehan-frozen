package com.daehan.frozen.userapi.store;

import com.daehan.frozen.userapi.entity.Member;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    public List<Member> getUsers();
    void insertUser(Member member);
    Member findByUsername(String username);
}
