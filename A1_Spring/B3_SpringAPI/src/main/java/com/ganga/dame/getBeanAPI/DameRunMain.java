package com.ganga.dame.getBeanAPI;

import com.ganga.dao.UserDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DameRunMain {

    public static void main(String[] args) {

        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");

        //id的方式
        //UserDao userDao1 = (UserDao) app.getBean("userDao");//需要强转一下
        //UserDao userDao2 = (UserDao) app.getBean("userDao2");//可以创建两个相同的class

        //class方式
        UserDao userDao1 = app.getBean(UserDao.class);//不需要强转
        /*
        * 如果配置文件种有多个Bean中UserDao.class时 会报错
        *
        *   <bean id="userDao" class="com.ganga.dao.impl.UserDaoImpl"></bean>
        *   <bean id="userDao2" class="com.ganga.dao.impl.UserDaoImpl"></bean>
        *
        *   class="com.ganga.dao.impl.UserDaoImpl" 为单个时 才能使用
        *
        * */
        userDao1.method();
        System.out.println(userDao1);
    }

}
