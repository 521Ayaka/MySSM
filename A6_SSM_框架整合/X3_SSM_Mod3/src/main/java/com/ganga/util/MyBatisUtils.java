package com.ganga.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

//自定义封装工具类
//用于获取MyBatis的 SqlSessionFactory对象从而获取SqlSession对象。
public class MyBatisUtils{

    private static SqlSessionFactory sqlSessionFactory;

    static {
        try {
            //使用MyBatis第一步: 获取sqlSessionFactory对象
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
     * 通过该方法获取 sqlSessionFactory对象
     *
     * sqlSession对象不要进行封装！ 多个资源公用一个sqlSession对象
     *   事务可能会出现问题！
     * */
    public static SqlSessionFactory getSqlSessionFactory(){
        return sqlSessionFactory;
    }


}