package com.ganga.dame.A3_新注解;

import com.ganga.config.SpringApplicationContext;
import com.ganga.service.AnnoFirstService;
import com.ganga.service.AnnoNewService;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MockServletAnnoNew {

    public static void main(String[] args) throws SQLException {

        //ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        //使用加载Spring配置类的方式
        ApplicationContext app = new AnnotationConfigApplicationContext(SpringApplicationContext.class);

        AnnoNewService annoNewService = (AnnoNewService) app.getBean("annoNewService");
        System.out.println(annoNewService);
        annoNewService.method();
        System.out.println(annoNewService);
        System.out.println("=======================");


        ComboPooledDataSource dataSource = (ComboPooledDataSource) app.getBean("dataSourceNew");
        Connection conn = dataSource.getConnection();
        String sql = "select * from tb_user;";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet resultSet = ps.executeQuery();
        while (resultSet.next()){
            String username = resultSet.getString("username");
            String password = resultSet.getString("password");
            System.out.println(username + " : " + password);
        }
        resultSet.close();
        ps.close();
        conn.close();


    }

}
