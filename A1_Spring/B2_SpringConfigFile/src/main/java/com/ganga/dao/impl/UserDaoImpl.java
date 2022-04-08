package com.ganga.dao.impl;

import com.ganga.dao.UserDao;

public class UserDaoImpl implements UserDao {

    public UserDaoImpl() {
        System.out.println("对象被创建...");
    }

    @Override
    public void method() {
        System.out.println("run method...");
    }


    public void init(){
        System.out.println("初始化方法执行...");
    }

    public void destroy(){
        System.out.println("销毁时的方法执行...");
    }

}
