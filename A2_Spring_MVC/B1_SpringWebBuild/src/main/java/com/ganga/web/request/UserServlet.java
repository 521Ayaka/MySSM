package com.ganga.web.request;

import com.ganga.config.SpringApplicationContext;
import com.ganga.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//@WebServlet("/userServlet")
public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //加载配置类 获取Spring容器
        ApplicationContext app = new AnnotationConfigApplicationContext(SpringApplicationContext.class);
        UserService userService = (UserService) app.getBean("userService");
        userService.SelectAll();

        System.out.println("=========演示二==========");
        response.setContentType("text/html;charset=utf8");
        PrintWriter writer = response.getWriter();
        DataSource dataSource = (DataSource) app.getBean("dataSource");
        try (Connection conn = dataSource.getConnection()){

            String sql = "select * from tb_user;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery();
            writer.write("<br><br><br>");
            while (resultSet.next()){
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                writer.write("          "+username+" : ");
                writer.write("          "+password);
                writer.write("<br><br>");
            }
            resultSet.close();
            ps.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println("页面展示");


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
