package com.ganga.listener;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

//@WebListener
public class ContextLoaderListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {

        //先获取ServletContext域
        ServletContext servletContext = sce.getServletContext();
        //从域当中获取信息
        String applicationContext = servletContext.getInitParameter("contextConfigLocation");

        //初始化Spring容器
        ApplicationContext app = new ClassPathXmlApplicationContext(applicationContext);

        //将Spring容器放入 ServletContext域 当中
        servletContext.setAttribute("app",app);

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }

}
