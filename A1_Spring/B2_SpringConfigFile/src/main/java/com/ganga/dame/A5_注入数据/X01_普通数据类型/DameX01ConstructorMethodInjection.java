package com.ganga.dame.A5_注入数据.X01_普通数据类型;

import com.ganga.dao.X01ConstructorDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//构造器方式注入
public class DameX01ConstructorMethodInjection {

    public static void main(String[] args) {

        ApplicationContext app = new ClassPathXmlApplicationContext("dameX01Injection02.xml");
        X01ConstructorDao x01ConstructorDao = (X01ConstructorDao) app.getBean("x01ConstructorDao");
        x01ConstructorDao.method();
        System.out.println(x01ConstructorDao);

    }

}
