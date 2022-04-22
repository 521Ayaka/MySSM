package com.ganga.dao;

public interface TransferDao {

    void out(String user,double money);

    void in(String user,double money);

}
