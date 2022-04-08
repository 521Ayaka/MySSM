package com.ganga.service.impl;

import com.ganga.dao.SetDao;
import com.ganga.service.SetService;

public class SetServiceImpl implements SetService {
    /*
    * set方式注入
    * */
    //新定义一个空的UserDao的对象
    private SetDao setDao;

    /**
     * 设置一个setSetDao的方法
     *      参数是注入的对象
     *
     * @param setDao
     */
    public void setSetDao(SetDao setDao){
        //将获取到的dao对象放入到定义好的UserDao对象上
        this.setDao = setDao;
    }

    @Override
    public void method() {
        //最后调用setDao对象的method()方法
        setDao.method();
    }
}
