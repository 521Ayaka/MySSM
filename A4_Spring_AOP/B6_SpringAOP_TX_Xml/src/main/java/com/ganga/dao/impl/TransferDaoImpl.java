package com.ganga.dao.impl;

import com.ganga.dao.TransferDao;
import org.springframework.jdbc.core.JdbcTemplate;

public class TransferDaoImpl implements TransferDao {

    private JdbcTemplate jdbcTemplate;
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public void out(String user, double money) {
        jdbcTemplate.update("update account set money = money-? where user = ?;",money,user);
    }

    @Override
    public void in(String user, double money) {
        jdbcTemplate.update("update account set money = money+? where user = ?;",money,user);
    }
}
