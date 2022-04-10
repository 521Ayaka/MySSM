package com.ganga.dao.impl;

import com.ganga.dao.AnnoNewDao;
import org.springframework.stereotype.Repository;

@Repository("annoNewDao")
public class AnnoNewDaoImpl implements AnnoNewDao {

    @Override
    public void method() {
        System.out.println("run AnnoNewDaoImpl");
    }

}
