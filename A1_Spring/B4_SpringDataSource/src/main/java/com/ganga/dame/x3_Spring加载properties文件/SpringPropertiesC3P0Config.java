package com.ganga.dame.x3_Spring加载properties文件;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SpringPropertiesC3P0Config {

    public static void main(String[] args) throws Exception {

        //加载配置文件
        ApplicationContext app = new ClassPathXmlApplicationContext("dameApplicationContext.xml");
        //通过getBean(id) 从容器中获取对象
        ComboPooledDataSource dataSource = (ComboPooledDataSource) app.getBean("c3p0DataSource");

        //在数据源中获取Connection连接对象
        Connection connection = dataSource.getConnection();

        String sql = "select * from tb_user;";
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet resultSet = ps.executeQuery();
        while (resultSet.next()){
            String username = resultSet.getString("username");
            String password = resultSet.getString("password");

            System.out.println(username + " : " + password);
        }

        //释放资源
        resultSet.close();
        ps.close();
        connection.close();

    }

}
