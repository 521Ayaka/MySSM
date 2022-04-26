package com.ganga.service.impl;

import com.ganga.mapper.UserMapper;
import com.ganga.pojo.User;
import com.ganga.service.UserService;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService{

    //spring容器指定生成对象 扫描到的 Mapper代理对象！ 这里只需要注入即可
    @Autowired
    private UserMapper userMapper;

    @Override
    public int addUser(String username) {
        int i = userMapper.addUser(username);
        return i;
    }

    @Override
    public List<User> userAll() {
        List<User> users = userMapper.selectAll();
        return users;
    }
}
