package com.ganga.dame.X2_Spring配置数据源;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidPooledConnection;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SpringDruidDataSourceConfig {

    public static void main(String[] args) throws Exception {

        //加载配置文件
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");

        //通过getBean(id) 从容器中获取对象
        DruidDataSource dataSource = (DruidDataSource) app.getBean("druidConfig");

        //在数据源中获取Connection连接对象
        DruidPooledConnection connection = dataSource.getConnection();

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
