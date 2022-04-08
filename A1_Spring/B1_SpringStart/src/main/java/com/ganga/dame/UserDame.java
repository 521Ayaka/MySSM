package com.ganga.dame;

import com.ganga.dao.UserDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserDame {

    public static void main(String[] args) {

        //创建ApplicationContext对象 加载配置文件
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        //通过app 获取容器中的对象
        UserDao userDao = (UserDao) app.getBean("userDao");
        //调用对象方法验证
        userDao.method();

    }

}
