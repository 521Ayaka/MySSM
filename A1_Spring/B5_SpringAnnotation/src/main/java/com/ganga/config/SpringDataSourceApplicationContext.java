package com.ganga.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

//需要引入properties文件
@PropertySource("classpath:jdbc.properties")
public class SpringDataSourceApplicationContext {

    //已经导入了jdbc.properties文件
    //这里直接注入数据
    @Value("${jdbc.driverClass}")
    private String driver;
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.user}")
    private String user;
    @Value("${jdbc.password}")
    private String password;

    //注入自定义的Bean 用@Bean注解 注到方法上 该方法的返回值为bean的对象
    @Bean("dataSourceNew")
    public DataSource getDataSource() throws Exception {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass(driver);
        dataSource.setJdbcUrl(url);
        dataSource.setUser(user);
        dataSource.setPassword(password);
        return dataSource;
    }

}
