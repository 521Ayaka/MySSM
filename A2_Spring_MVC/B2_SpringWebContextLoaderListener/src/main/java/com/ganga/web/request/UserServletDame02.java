package com.ganga.web.request;

import com.ganga.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/userServletDame02")
public class UserServletDame02 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ServletContext servletContext = this.getServletContext();

        //使用Spring-web 提供的工具了
        ApplicationContext app = WebApplicationContextUtils.getWebApplicationContext(servletContext);


        System.out.println("=========演示一==========");

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
