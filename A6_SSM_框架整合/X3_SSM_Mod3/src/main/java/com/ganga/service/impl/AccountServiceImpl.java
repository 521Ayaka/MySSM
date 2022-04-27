package com.ganga.service.impl;


import com.ganga.mapper.AccountMapper;
import com.ganga.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("accountService")
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountMapper accountMapper;
    /**
     * 业务逻辑
     * @param outMan 转出人
     * @param inMan  转入人
     * @param money  转账金额
     */
    @Override
    public void transfer(String outMan, String inMan, double money) {
        accountMapper.out(outMan,money);
        System.out.println("======");
        //int i = 1/0; //模拟异常
        accountMapper.in(inMan,money);
    }
}
