package com.ganga.test;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
import java.util.ResourceBundle;

public class DataSourceTest {

    /**
     * 测试手动创建并配置 Druid 数据源
     * @throws Exception
     */
    @Test
    public void testDruidDataSource() throws Exception {
        System.out.println("\n\n============= 01 =============");
        System.out.println("run testDruidDataSource...");

        //1. 导入坐标

        //2. 创建数据源对象
        DruidDataSource dataSource = new DruidDataSource();

        //3. 设置数据源的基本配置信息
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql:///webcase?useSSL=false&useServerPrepStmts=true");
        dataSource.setUsername("root");
        dataSource.setPassword("ganga");

        //4. 使用数据源获取连接资源 和 归还连接资源
        Connection conn = dataSource.getConnection();
        System.out.println(conn);
        
        String sql = "select * from tb_user;";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet resultSet = ps.executeQuery();
        while (resultSet.next()){
            String username = resultSet.getString("username");
            String password = resultSet.getString("password");
            System.out.println(username + " : " + password);
        }

        //释放资源
        resultSet.close();
        ps.close();
        conn.close();

    }


    /**
     * 测试手动创建并配置 Druid 数据源
     *      使用配置文件进行配置
     * @throws Exception
     */
    @Test
    public void testDruidDataSourceConfig() throws Exception {
        System.out.println("\n\n============= 02 =============");
        System.out.println("run testDruidDataSourceConfig...");

        //获取Properties对象
        Properties prop = new Properties();
        //加载上配置文件
        prop.load(new FileInputStream("src\\main\\resources\\druid.properties"));
        //通过德鲁伊数据源工厂的createDataSource(prop)的方法 获取数据源
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);

        //使用数据源获取连接资源 和 归还连接资源
        Connection conn = dataSource.getConnection();

        String sql = "select * from tb_user;";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet resultSet = ps.executeQuery();
        while (resultSet.next()){
            String username = resultSet.getString("username");
            String password = resultSet.getString("password");
            System.out.println(username + " : " + password);
        }

        //释放资源
        resultSet.close();
        ps.close();
        conn.close();
    }


    @Test
    public void testC3P0DataSource() throws Exception {
        System.out.println("\n\n============= 03 =============");
        System.out.println("run testC3P0DataSource...");

        //1. 导入依赖坐标
        //2. 创建数据源对象
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        //3. 设置设置数据源的基本配置信息
        dataSource.setDriverClass("com.mysql.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql:///webcase?useSSL=false&useServerPrepStmts=true");
        dataSource.setUser("root");
        dataSource.setPassword("ganga");

        //4. 使用数据源获取连接资源 和 归还连接资源
        Connection conn = dataSource.getConnection();
        System.out.println(conn);

        String sql = "select * from tb_user;";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet resultSet = ps.executeQuery();
        while (resultSet.next()){
            String username = resultSet.getString("username");
            String password = resultSet.getString("password");
            System.out.println(username + " : " + password);
        }

        //释放资源
        resultSet.close();
        ps.close();
        conn.close();

    }

    @Test
    public void testC3p0DataSourceConfig() throws Exception {
        System.out.println("\n\n============= 04 =============");
        System.out.println("run testC3p0DataSourceConfig...");

        //加载配置文件
        ResourceBundle rb = ResourceBundle.getBundle("jdbc");
        String driverClass = rb.getString("jdbc.driverClass");
        String url = rb.getString("jdbc.url");
        String user = rb.getString("jdbc.user");
        String password = rb.getString("jdbc.password");

        //创建数据源对象
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        //导入数据源的基本配置信息
        dataSource.setDriverClass("com.mysql.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql:///webcase?useSSL=false&useServerPrepStmts=true");
        dataSource.setUser("root");
        dataSource.setPassword("ganga");
        //使用数据源获取连接资源 和 归还连接资源
        Connection conn = dataSource.getConnection();

        System.out.println(conn);

        String sql = "select * from tb_user;";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet resultSet = ps.executeQuery();
        while (resultSet.next()){
            String getUsername = resultSet.getString("username");
            String getPassword = resultSet.getString("password");
            System.out.println(getUsername + " : " + getPassword);
        }

        //释放资源
        resultSet.close();
        ps.close();
        conn.close();


    }



}
