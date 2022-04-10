package com.ganga.dame.A2_原注解;

import com.ganga.service.AnnoFirstService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MockServletAnnoFirst {

    public static void main(String[] args) throws SQLException {

        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        AnnoFirstService annoFirstService = (AnnoFirstService) app.getBean("annoFirstService");
        annoFirstService.method();
        System.out.println(annoFirstService);

        //模拟销毁容器
        ((ClassPathXmlApplicationContext) app).close();

    }

}
