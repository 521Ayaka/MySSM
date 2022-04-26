package com.ganga.mapper;

import com.ganga.pojo.User;

import java.util.List;

public interface UserMapper {

    int addUser(String username);

    //@Select("select * from ssm_user;")
    List<User> selectAll();

}
