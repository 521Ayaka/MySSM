package com.ganga.test;

import com.ganga.config.SpringApplicationContext;
import com.ganga.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

//第一步: 导入spring-test坐标

//第二步: 使用@Runwith注解替换原来的运行期
@RunWith(SpringJUnit4ClassRunner.class)

//第三步: 指定配置文件/配置类用 @ContextConfiguration
@ContextConfiguration(classes = {SpringApplicationContext.class} )
//@ContextConfiguration("classpath:applicationContext.xml")

public class SpringJunitRunTest {

    //第四步: 使用Autowired注入需要测试的对象
    @Autowired
    private UserService userService;

    //第五步: 创建测试方法进行测试
    @Test
    public void userServiceTest(){
        userService.SelectAll();
    }

    @Autowired
    //@Qualifier("dataSource")
    private DataSource dataSource;
    @Test
    public void dataSourceTest() throws SQLException {
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        connection.close();
    }

}
