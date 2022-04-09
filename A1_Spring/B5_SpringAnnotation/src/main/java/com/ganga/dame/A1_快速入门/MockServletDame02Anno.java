package com.ganga.dame.A1_快速入门;

import com.ganga.service.AnnoService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MockServletDame02Anno {

    public static void main(String[] args) {

        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        AnnoService annoService = (AnnoService) app.getBean("annoService");
        annoService.method();
        System.out.println(annoService);

    }

}
