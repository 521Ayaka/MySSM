package com.ganga.dame.A1_快速入门;

import com.ganga.dao.UserDao;
import com.ganga.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MockServletDame01 {

    public static void main(String[] args) {

        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = (UserService) app.getBean("userService");
        userService.method();
        System.out.println(userService);

    }

}
