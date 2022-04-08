package com.ganga.service.impl;

import com.ganga.dao.UserDao;
import com.ganga.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserServiceImpl implements UserService {

    @Override // 08
    public void method() {

        //加载配置文件
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        //调用dao层
        UserDao userDao = (UserDao) app.getBean("userDao");
        //调用方法
        userDao.method();

    }




}
