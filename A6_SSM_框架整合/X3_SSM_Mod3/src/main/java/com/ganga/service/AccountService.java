package com.ganga.service;

public interface AccountService {

    /**
     * 转入转出 业务逻辑
     * @param outMan 转出人
     * @param inMan 转入人
     * @param money 转账金额
     */
    public void transfer(String outMan,String inMan,double money);

}
