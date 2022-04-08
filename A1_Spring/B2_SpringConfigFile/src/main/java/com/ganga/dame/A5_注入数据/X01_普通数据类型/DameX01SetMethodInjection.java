package com.ganga.dame.A5_注入数据.X01_普通数据类型;

import com.ganga.dao.X01SetDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//set方式注入
public class DameX01SetMethodInjection {

    public static void main(String[] args) {

        ApplicationContext app = new ClassPathXmlApplicationContext("dameX01Injection01.xml");
        X01SetDao x01Dao = (X01SetDao) app.getBean("x01SetDao");
        x01Dao.method();
        System.out.println(x01Dao);

    }

}
