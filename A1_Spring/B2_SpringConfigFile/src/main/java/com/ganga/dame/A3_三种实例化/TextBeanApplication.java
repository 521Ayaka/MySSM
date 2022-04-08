package com.ganga.dame.A3_三种实例化;

import com.ganga.dao.UserDao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TextBeanApplication {

    @Test //05 无参构造方法实例化
    public void textBeanApplication(){

        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao = (UserDao) app.getBean("userDao");
        userDao.method();
        System.out.println(userDao);
        /*创建成功:
        *   对象被创建...
        *   run method...
        *   com.ganga.dao.impl.UserDaoImpl@44ebcd03
        * */

    }


    @Test //06 工厂静态方法实例化
    public void textStaticFaction(){

        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao = (UserDao) app.getBean("userDao");
        userDao.method();
        System.out.println(userDao);
        /*创建成功:
        *   对象被创建...
        *   run method...
        *   com.ganga.dao.impl.UserDaoImpl@2a798d51
        * */

    }


    @Test //07 工厂实例化方法实例化
    public void textDynamicFaction(){

        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao = (UserDao) app.getBean("userDao");
        userDao.method();
        System.out.println(userDao);
        /*创建成功:
         *   对象被创建...
         *   run method...
         *   com.ganga.dao.impl.UserDaoImpl@2a798d51
         * */
    }

}
