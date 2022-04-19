package com.ganga.servlet.impl;

import com.ganga.servlet.UserDao;

public class UserDaoImpl implements UserDao {
    @Override
    public int getAge(String name, int age) {
        System.out.println("目标方法执行......");
        System.out.println("代理前的目标结果是:" + age);
        return age;
    }
}
