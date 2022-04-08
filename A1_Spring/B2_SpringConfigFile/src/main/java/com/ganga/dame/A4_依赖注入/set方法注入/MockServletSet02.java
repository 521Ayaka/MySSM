package com.ganga.dame.A4_依赖注入.set方法注入;

import com.ganga.service.SetService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MockServletSet02 {

    public static void main(String[] args) {

        ApplicationContext app = new ClassPathXmlApplicationContext("dameSetInjection02.xml");
        SetService setService = (SetService) app.getBean("setService");
        setService.method();

    }

}
