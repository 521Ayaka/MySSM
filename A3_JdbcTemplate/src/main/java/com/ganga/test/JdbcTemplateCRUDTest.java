package com.ganga.test;

import com.ganga.pojo.Account;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

//替换原生测试内核
@RunWith(SpringJUnit4ClassRunner.class)
//加载配置文件
@ContextConfiguration("classpath:applicationContext.xml")
public class JdbcTemplateCRUDTest {

    //注入需要的对象
    @Autowired
    private JdbcTemplate jdbcTemplate;

    //测试添加操作
    @Test
    public void updateAddTest(){
        String sql = "insert into account values(?,?)";
        int row = jdbcTemplate.update(sql, "gangale", "1");
        System.out.println(row);
    }

    //测试删除操作
    @Test
    public void updateDeleteTest(){
        String sql = "delete from account where user = ?";
        int row = jdbcTemplate.update(sql, "gangale");
        System.out.println(row);
    }

    //测试修改操作
    @Test
    public void updateUpdateTest(){
        String sql = "update account set money=? where user=?";
        int row = jdbcTemplate.update(sql,"2","gangale");
        System.out.println(row);
    }


    /**
     * 测试 常用的 查询操作 01
     * <T> List<T> query(String sql,RowMapper<T> rowMapper)
     *
     * RowMapper<T>实现类: BeanPropertyRowMapper<T>
     *
     *  BeanPropertyRowMapper<T> T是要封装的类型
     *
     *  BeanPropertyRowMapper<T>(T.Class) 构造参数是要封装的类型的字节码文件
     *
     *  List<T> BeanPropertyRowMapper<T>(T.Class) 返回的数据类型是List<T>
     *
     *  演示
     *  query(sql, new BeanPropertyRowMapper<Account>(Account.class))
     */
    @Test
    public void querySelectTest01(){
        String sql = "select * from account";
        List<Account> query = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Account>(Account.class));
        System.out.println(query);
    }


    /**
     * 测试 常用的 查询操作 02
     *
     * <T> T queryForObject(
     *      <T> List<T> query(String sql, RowMapper<T> rowMapper, @Nullable Object... args)
     *  )方法
     *
     *  RowMapper<T> rowMapper 和上面一样 只是可以设置参数以及阐述占位符
     *
     *  返回值直接是一个 T 而不是List<T>
     *      也就是说直接返回一个对象
     *
     *  演示
     *  query(sql, new BeanPropertyRowMapper<Account>(Account.class),"ganga")
     */
    @Test
    public void querySelectTest02(){

        String sql = "select * from account where user=?";
        Account ganga = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Account>(Account.class), "ganga");
        System.out.println(ganga);

    }

    /**
     * 测试 常用的 查询操作 02
     *
     * <T> T queryForObject(
     *      <T> List<T> queryForList(String sql, Class<T> elementType)
     *  )方法
     *
     *  Class<T> elementType 可以是一些简单的数据类型 如： Long  Double Integer ...
     *
     *  返回值直接是一个 T 而不是List<T>
     *      也就是说直接返回一个对象
     *
     *
     *
     *  演示
     *  queryForList(sql, Long.class)
     */
    @Test
    public void querySelectTest03(){

        String sql = "select count(*) from account";
        List<Long> longs = jdbcTemplate.queryForList(sql, Long.class);
        System.out.println(longs);

    }

}
