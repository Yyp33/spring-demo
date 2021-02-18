package com.yyp.spring.dao.impl;

import com.alibaba.druid.pool.DruidDataSource;
import com.yyp.spring.dao.UserDao;
import com.yyp.spring.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {

    JdbcTemplate jdbcTemplate;

    @Autowired
    public UserDaoImpl(DruidDataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public User getUser(){
        User user = jdbcTemplate.queryForObject("select * from user where id = 1 "
                , new BeanPropertyRowMapper<>(User.class));
        return user;
    }

    @Override
    public void sub(){
        int  res = jdbcTemplate.update("update user set balance=balance-100 where id = ? "
                , 1);
    }

    @Override
    public void add(){
        int  res = jdbcTemplate.update("update user set balance=balance+100 where id = ? "
                , 2);
    }
}
