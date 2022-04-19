package com.ganga;

import com.ganga.handler.UserInvocationHandler;
import com.ganga.servlet.UserDao;
import com.ganga.servlet.impl.UserDaoImpl;

public class DameUser {

    public static void main(String[] args) {

        //创建目标对象
        UserDao userDao = new UserDaoImpl();

        //创建代理工厂对象 调用getInstance()方法 返回代理对象
        UserDao proxy = (UserDao) new UserInvocationHandler().getInstance(userDao);

        //调用方法
        int age = proxy.getAge("尴尬酱", 9);

        //输出结果
        System.out.println("增强方法后的 代理后的 返回结果:"+age);

    }

}
