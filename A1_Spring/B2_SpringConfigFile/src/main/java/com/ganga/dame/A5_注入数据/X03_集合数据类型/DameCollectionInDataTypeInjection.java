package com.ganga.dame.A5_注入数据.X03_集合数据类型;

import com.ganga.dao.X03Dao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DameCollectionInDataTypeInjection {

    public static void main(String[] args) {

        ApplicationContext app = new ClassPathXmlApplicationContext("dameX03Injection.xml");
        X03Dao x03Dao = (X03Dao) app.getBean("x03Dao");
        x03Dao.method();
        System.out.println(x03Dao);

    }

}
