package com.ganga.dao.impl;

import com.ganga.dao.X01ConstructorDao;

public class X01ConstructorDaoImpl implements X01ConstructorDao {

    private String username;
    private int age;

    public X01ConstructorDaoImpl() {
    }
    //ćšćæé 
    public X01ConstructorDaoImpl(String username, int age) {
        this.username = username;
        this.age = age;
    }

    @Override
    public void method() {
        System.out.println(username);
        System.out.println(age);
        System.out.println("run X01ConstructorDaoImpl");
    }

}
