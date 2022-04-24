package com.ganga.service.impl;

import com.ganga.dao.TransferDao;
import com.ganga.service.TransferService;

public class TransferServiceImpl implements TransferService {

    //注入Dao对象
    private TransferDao transferDao;
    public void setTransferDao(TransferDao transferDao) {
        this.transferDao = transferDao;
    }

    /**
     * 业务逻辑
     * @param outMan 转出人
     * @param inMan  转入人
     * @param money  转账金额
     */
    @Override
    public void transfer(String outMan, String inMan, double money) {
        transferDao.out(outMan,money);
        System.out.println("======");
        int i = 1/0;
        transferDao.in(inMan,money);
    }
}
