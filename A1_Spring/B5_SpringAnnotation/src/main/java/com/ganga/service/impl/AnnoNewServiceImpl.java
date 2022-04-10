package com.ganga.service.impl;

import com.ganga.dao.AnnoNewDao;
import com.ganga.service.AnnoNewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("annoNewService")
public class AnnoNewServiceImpl implements AnnoNewService {

    @Autowired
    //@Qualifier("annoNewDao")
    //@Resource(name = "annoNewDao")
    private AnnoNewDao annoNewDao;

    @Override
    public void method() {

        annoNewDao.method();

    }
}
