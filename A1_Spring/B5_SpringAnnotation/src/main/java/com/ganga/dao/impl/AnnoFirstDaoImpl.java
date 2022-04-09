package com.ganga.dao.impl;

import com.ganga.dao.AnnoFirstDao;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

//添加bean id="annoFirstDao"
//dao层 用 @Repository
@Repository("annoFirstDao")
public class AnnoFirstDaoImpl implements AnnoFirstDao {

    //初始化方法 init-method --> @PostConstruct注解
    @PostConstruct
    public void init(){
        System.out.println("初始化方法执行...");
    }

    //销毁方法 destroy-method --> @PreDestroy注解
    @PreDestroy
    public void destroy(){
        System.out.println("销毁方法执行...");
    }

    @Override
    public void method() {
        System.out.println("run AnnoFirstDaoImpl method...");
    }

}
