package com.ganga.service.impl;

import com.ganga.dao.TransferDao;
import com.ganga.service.TransferService;

public class TransferServiceImpl implements TransferService {

    private TransferDao transferDao;

    public void setTransferDao(TransferDao transferDao) {
        this.transferDao = transferDao;
    }

    /**
     * 业务逻辑
     * @param outMan
     * @param inMan
     * @param money
     */
    @Override
    public void transfer(String outMan, String inMan, double money) {
        transferDao.out(outMan,money);
        System.out.println("======");
        int i = 1/0;
        transferDao.in(inMan,money);
    }
}
