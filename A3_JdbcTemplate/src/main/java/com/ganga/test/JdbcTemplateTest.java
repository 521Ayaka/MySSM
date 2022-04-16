package com.ganga.test;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.testng.annotations.Test;

import javax.sql.DataSource;
import javax.xml.crypto.Data;
import java.beans.PropertyVetoException;

public class JdbcTemplateTest {

    @Test
    public void entryTest01() throws PropertyVetoException {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        //要指定相应的数据源 jdbcTemplate.setDataSource
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass("com.mysql.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql:///webcase?useSSL=false");
        dataSource.setUser("root");
        dataSource.setPassword("ganga");
        //设置数据源信息
        jdbcTemplate.setDataSource(dataSource);

        //执行操作
        int row = jdbcTemplate.update("insert into account values(?,?)", "ganga", 100000000);
        System.out.println(row);

        /*int row = jdbcTemplate.update("delete from account where user = ? ", "ganga");
        System.out.println(row);*/
    }

    /*
    *
    * 上面与之前学过的 进行改造
    *
    * */

    @Test
    public void entryTest02(){
        //直接从容器中获取已经注入好数据源的JdbcTemplate对象
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        JdbcTemplate jdbcTemplate = app.getBean(JdbcTemplate.class);

        //执行操作
        int row = jdbcTemplate.update("insert into account values(?,?)","gangajiang","1230000");
        System.out.println(row);

    }


}
