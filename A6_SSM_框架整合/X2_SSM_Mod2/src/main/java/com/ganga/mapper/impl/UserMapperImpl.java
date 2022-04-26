package com.ganga.mapper.impl;

import com.ganga.mapper.UserMapper;
import com.ganga.pojo.User;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Repository("userMapper")
public class UserMapperImpl extends SqlSessionDaoSupport implements UserMapper {

    @Override
    public int addUser(String username) {
        return super.getSqlSession().getMapper(UserMapper.class).addUser(username);
    }

    @Override
    public List<User> selectAll() {
        return super.getSqlSession().getMapper(UserMapper.class).selectAll();
    }
}
