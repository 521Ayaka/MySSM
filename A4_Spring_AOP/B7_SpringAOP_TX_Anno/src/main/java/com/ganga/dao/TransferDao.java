package com.ganga.dao;

public interface TransferDao {

    /**
     * 转出
     * @param user 转出人
     * @param money 转出的钱
     */
    void out(String user,double money);

    /**
     * 转入
     * @param user 转入人
     * @param money 转入的钱
     */
    void in(String user,double money);

}
