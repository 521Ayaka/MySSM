package com.ganga.dao.impl;

import com.ganga.dao.TransferDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class TransferDaoImpl implements TransferDao {

    //注入SpringJdbcTemplate对象
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void out(String user, double money) {
        jdbcTemplate.update("update account set money = money-? where user = ?;",money,user);
    }

    @Override
    public void in(String user, double money) {
        jdbcTemplate.update("update account set money = money+? where user = ?;",money,user);
    }
}
