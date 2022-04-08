package com.ganga.dame.A2_生命周期;

import com.ganga.dao.UserDao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestLifeCycle {

    @Test //打开03
    public void textSingleton(){
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        System.out.println("============");

        UserDao userDao1 = (UserDao) app.getBean("userDao");
        UserDao userDao2 = (UserDao) app.getBean("userDao");

        System.out.println(userDao1);
        System.out.println(userDao2);

        //模拟容器销毁
        ((ClassPathXmlApplicationContext) app).close();

        /*
        * 运行结果:
        *   对象被创建...
        *   初始化方法执行...
        *   ============
        *   com.ganga.dao.impl.UserDaoImpl@359f7cdf
        *   com.ganga.dao.impl.UserDaoImpl@359f7cdf
        *   4月 07, 2022 10:49:14 上午 org.springframework.context.support.AbstractApplicationContext doClose
        *   信息: Closing org.springframework.context.support.ClassPathXmlApplicationContext@6d8a00e3: startup date [Thu Apr 07 10:49:13 CST 2022]; root of context hierarchy
        *
        * 在加载配置文件时 初始化方法被执行
        *
        * */
    }

    @Test //打开04
    public void textPrototype(){
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        System.out.println("============");

        UserDao userDao1 = (UserDao) app.getBean("userDao");
        UserDao userDao2 = (UserDao) app.getBean("userDao");

        System.out.println(userDao1);
        System.out.println(userDao2);

        //模拟容器销毁
        ((ClassPathXmlApplicationContext) app).close();

        /*
        * 运行结果:
        *   ============
        *   对象被创建...
        *   初始化方法执行...
        *   对象被创建...
        *   初始化方法执行...
        *   com.ganga.dao.impl.UserDaoImpl@6aba2b86
        *   com.ganga.dao.impl.UserDaoImpl@158da8e
        *   4月 07, 2022 10:58:26 上午 org.springframework.context.support.AbstractApplicationContext doClose
        *   信息: Closing org.springframework.context.support.ClassPathXmlApplicationContext@6d8a00e3: startup date [Thu Apr 07 10:58:26 CST 2022]; root of context hierarchy
        *
        * 在被调用获取/创建对象时 被执行 init()方法
        * 不是随容器而销毁的
        * 在被java垃圾回收机制销毁时执行 destroy销毁方法
        *
        * */

    }


}
