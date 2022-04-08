package com.ganga.dame.ApplicationContextAPI;

import com.ganga.dao.UserDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class DameRunMain {

    public static void main(String[] args) {

        //方式一:
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");

        //方式二:
        //ApplicationContext app = new FileSystemXmlApplicationContext("D:\\MySSM\\A1_Spring\\B3_SpringAPI\\src\\main\\resources\\applicationContext.xml");


        //方式三: AnnotationConfigApplicationContext
        //TODO:这种方式学完注解开发 后 在进行学习

        UserDao userDao = (UserDao) app.getBean("userDao");
        userDao.method();
        System.out.println(userDao);
    }



}
