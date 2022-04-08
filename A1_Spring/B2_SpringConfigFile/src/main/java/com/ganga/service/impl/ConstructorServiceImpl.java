package com.ganga.service.impl;

import com.ganga.dao.ConstructorDao;
import com.ganga.service.ConstructorService;

public class ConstructorServiceImpl implements ConstructorService {

    //创建ConstructorDao的空对象
    private ConstructorDao constructorDao;

    //无参构造方法
    public ConstructorServiceImpl(){

    }

    //有参构造
    public ConstructorServiceImpl(ConstructorDao constructorDao){
        //将参数放入constructorDao对象当中
        this.constructorDao = constructorDao;
    }

    @Override
    public void method() {
        //最后调用方法
        constructorDao.method();
    }


}
