package com.ganga.service.impl;

import com.ganga.config.SpringApplicationContext;
import com.ganga.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Override
    public void SelectAll() {
        ApplicationContext app = new AnnotationConfigApplicationContext(SpringApplicationContext.class);
        DataSource dataSource = (DataSource) app.getBean("dataSource");
        try {
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
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
