package com.ganga.dao.impl;

import com.ganga.dao.AnnoDao;
import org.springframework.stereotype.Component;

//<bean id="userDao" class="com.ganga.dao.impl.AnnoDaoImpl"></bean>
@Component("annoDao")
public class AnnoDaoImpl implements AnnoDao {

    @Override
    public void method() {
        System.out.println("run AnnoDaoImpl method...");
    }

}
