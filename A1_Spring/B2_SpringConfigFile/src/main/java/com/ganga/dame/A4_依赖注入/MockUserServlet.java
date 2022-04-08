package com.ganga.dame.A4_依赖注入;

import com.ganga.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 模拟 Web层
 */
public class MockUserServlet {

    public static void main(String[] args) {
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = (UserService) app.getBean("userServlet");
        userService.method();
    }

}
