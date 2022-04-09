package com.ganga.dame.A2_原始注解;

import com.ganga.service.AnnoFirstService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MockServletAnnoFirst {

    public static void main(String[] args) {

        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        AnnoFirstService annoFirstService = (AnnoFirstService) app.getBean("annoFirstService");
        annoFirstService.method();
        System.out.println(annoFirstService);

        //模拟销毁容器
        ((ClassPathXmlApplicationContext) app).close();

    }

}
