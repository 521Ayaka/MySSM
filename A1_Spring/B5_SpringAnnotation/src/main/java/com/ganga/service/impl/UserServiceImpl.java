package com.ganga.service.impl;

import com.ganga.dao.UserDao;
import com.ganga.service.UserService;

public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void method() {
        userDao.method();
    }
}
