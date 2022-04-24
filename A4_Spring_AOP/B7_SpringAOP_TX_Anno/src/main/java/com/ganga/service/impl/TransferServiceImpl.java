package com.ganga.service.impl;

import com.ganga.dao.TransferDao;
import com.ganga.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
//作用在类上 该类的所有方法都被事务管理
@Transactional(isolation=Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, timeout = -1, readOnly = false)
public class TransferServiceImpl implements TransferService {

    //注入Dao对象
    @Autowired
    private TransferDao transferDao;

    /**
     * 业务逻辑
     * @param outMan 转出人
     * @param inMan  转入人
     * @param money  转账金额
     */
    @Override
    //作用在方法上 该方法被该事务管理   这里使用该方法的事务
    @Transactional(isolation=Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, timeout = -1, readOnly = false)
    public void transfer(String outMan, String inMan, double money) {
        transferDao.out(outMan,money);
        System.out.println("======");
        int i = 1/0;
        transferDao.in(inMan,money);
    }
}
