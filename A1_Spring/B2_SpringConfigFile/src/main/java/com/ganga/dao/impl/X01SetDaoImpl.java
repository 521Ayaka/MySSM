package com.ganga.dao.impl;

import com.ganga.dao.X01SetDao;
//普通数据类型 注入
public class X01SetDaoImpl implements X01SetDao {

    private String username;
    private int age;

    public void setUsername(String username) {
        this.username = username;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public void method() {
        System.out.println(username);
        System.out.println(age);
        System.out.println("run X01DaoImpl method...");
    }


}
