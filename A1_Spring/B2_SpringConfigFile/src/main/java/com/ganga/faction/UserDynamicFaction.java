package com.ganga.faction;

import com.ganga.dao.UserDao;
import com.ganga.dao.impl.UserDaoImpl;

public class UserDynamicFaction {

    /**
     * 实例化工厂获取 UserDao实例化对象
     * @return
     */
    public UserDao getUserDao(){
        return new UserDaoImpl();
    }

}
