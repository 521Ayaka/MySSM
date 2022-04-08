package com.ganga.faction;

import com.ganga.dao.UserDao;
import com.ganga.dao.impl.UserDaoImpl;

public class UserFactionStatic {

    /**
     * 静态工厂获取 UserDao实例化对象
     * @return
     */
    public static UserDao getUserDao(){
        return new UserDaoImpl();
    }

}
