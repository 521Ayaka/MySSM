package com.ganga.dao.impl;

import com.ganga.dao.X03Dao;
import com.ganga.pojo.User;

import java.util.List;
import java.util.Map;
import java.util.Properties;

public class X03DaoImpl implements X03Dao {

    //注入List集合
    private List<String> stringList;
    private List<User> userList;
    //注入Map集合
    private Map<String, User> stringUserMap;
    //注入Properties
    private Properties properties;

    //注入List集合 set方法
    public void setStringList(List<String> stringList) {
        this.stringList = stringList;
    }
    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    //注入Map集合 set方法
    public void setStringUserMap(Map<String, User> stringUserMap) {
        this.stringUserMap = stringUserMap;
    }

    //注入Properties set方法
    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    @Override
    public void method() {
        System.out.println("====== List ======");
        System.out.println(stringList);
        for (User user : userList) {
            System.out.println(user);
        }

        System.out.println("\n====== Map ======");
        System.out.println(stringUserMap);

        System.out.println("\n====== Properties ======");
        System.out.println(properties);

        System.out.println("\nrun X03DaoImpl method...");
    }
}
