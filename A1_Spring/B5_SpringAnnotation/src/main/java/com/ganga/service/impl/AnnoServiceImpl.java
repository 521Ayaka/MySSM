package com.ganga.service.impl;

import com.ganga.dao.AnnoDao;
import com.ganga.service.AnnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("annoService")
public class AnnoServiceImpl implements AnnoService {

    @Autowired
    @Qualifier("annoDao")
    private AnnoDao annoDao;

    public void setUserDao(AnnoDao annoDao) {
        this.annoDao = annoDao;
    }

    @Override
    public void method() {
        annoDao.method();
    }
}
