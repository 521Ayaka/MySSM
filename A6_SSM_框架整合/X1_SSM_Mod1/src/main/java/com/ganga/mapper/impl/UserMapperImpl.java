package com.ganga.mapper.impl;

import com.ganga.mapper.UserMapper;
import com.ganga.pojo.User;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("userMapper")
public class UserMapperImpl implements UserMapper {

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    @Override
    public int addUser(String username) {
        UserMapper mapper = sqlSessionTemplate.getMapper(UserMapper.class);
        return mapper.addUser(username);
    }

    @Override
    public List<User> selectAll() {
        UserMapper mapper = sqlSessionTemplate.getMapper(UserMapper.class);
        return mapper.selectAll();
    }
}
