package com.ganga.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

//加载资源
@PropertySource({"classpath:jdbc.properties"})
public class DataSourceConfigBean {

    //注入jdbc.properties 配置信息
    @Value("${jdbc.driverClass}")
    private String driver;
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.user}")
    private String user;
    @Value("${jdbc.password}")
    private String password;

    //将返回的DataSource 放入Spring容器当中

    public DataSource getDataSource() throws Exception {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass(driver);
        dataSource.setJdbcUrl(url);
        dataSource.setUser(user);
        dataSource.setPassword(password);
        return dataSource;
    }

}
