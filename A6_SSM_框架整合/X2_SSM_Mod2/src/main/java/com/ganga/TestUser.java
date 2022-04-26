package com.ganga;

import com.ganga.mapper.UserMapper;
import com.ganga.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestUser {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void me01(){
        List<User> users = userMapper.selectAll();
        System.out.println(users);
    }

}
