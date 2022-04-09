package com.ganga.service.impl;

import com.ganga.dao.AnnoFirstDao;
import com.ganga.service.AnnoFirstService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

//添加bean id="annoFirstService"
//Service层 用 @Service
@Service("annoFirstService")
public class AnnoFirstServiceImpl implements AnnoFirstService {

    //注入引用数据用Autowired
    //@Autowired
    //@Qualifier("annoFirstDao") //按照id值 从容器中进行匹配
    //不加 @Qualifier 会按照数据类型从Spring容器中进行匹配  类型为1个时可以省略
    @Resource(name = "annoFirstDao")
    //@Resource 相当于 @Autowired + @Qualifier
    private AnnoFirstDao annoFirstDao;

    //注入普通数据用@Value  一般和el表达式一起用才有价值
    @Value("${jdbc.driverClass}")
    private String driver;

    //用注解开发 不用 set方法也行
    /*public void setAnnoFirstDao(AnnoFirstDao annoFirstDao) {
        this.annoFirstDao = annoFirstDao;
    }*/

    @Override
    public void method() {
        System.out.println("-------------------------------");
        System.out.println("driver: " + driver);
        System.out.println("-------------------------------");
        annoFirstDao.method();
    }

}
