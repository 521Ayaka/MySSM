package com.ganga.dame.A1_scope;

import com.ganga.dao.UserDao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class TestScope {


    @Test //打开 00/01
    public void testScope01(){
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        System.out.println("=============");

        UserDao userDao1 = (UserDao) app.getBean("userDao");
        UserDao userDao2 = (UserDao) app.getBean("userDao");

        System.out.println(userDao1);
        System.out.println(userDao2);

        /*
        * 运行结果:
        *   对象被创建...
        *   =============
        *   com.ganga.dao.impl.UserDaoImpl@44ebcd03
        *   com.ganga.dao.impl.UserDaoImpl@44ebcd03
        *
        * 分析:
        *   将scope设置成默认: singleton 时
        *       对象被创建一次
        *       创建时 是在加载文件时创建的
        *       对象只有一次
        *
        * */

    }


    @Test //打开02
    public void testScope02(){

        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        System.out.println("=============");

        UserDao userDao1 = (UserDao) app.getBean("userDao");
        UserDao userDao2 = (UserDao) app.getBean("userDao");

        System.out.println(userDao1);
        System.out.println(userDao2);

        /*
         * 运行结果:
         *   =============
         *   对象被创建...
         *   对象被创建...
         *   com.ganga.dao.impl.UserDaoImpl@6aba2b86
         *   com.ganga.dao.impl.UserDaoImpl@158da8e
         *
         * 分析:
         *   将scope设置为: prototype 时
         *       对象可以被多次创建
         *       创建时机: 在加载配置后 调用获取getBean()时 创建
         *       对象可有多次
         *
         * */
    }


}
