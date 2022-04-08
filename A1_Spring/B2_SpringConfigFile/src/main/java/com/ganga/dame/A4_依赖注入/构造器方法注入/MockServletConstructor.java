package com.ganga.dame.A4_依赖注入.构造器方法注入;

import com.ganga.service.ConstructorService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MockServletConstructor {

    public static void main(String[] args) {

        ApplicationContext app = new ClassPathXmlApplicationContext("dameConstructorInjection.xml");
        ConstructorService constructorService = (ConstructorService) app.getBean("constructorService");
        constructorService.method();
        System.out.println(constructorService);

    }

}
