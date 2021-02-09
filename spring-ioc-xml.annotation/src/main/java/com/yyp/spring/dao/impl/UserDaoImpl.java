package com.yyp.spring.dao.impl;

import org.springframework.stereotype.Repository;

import com.yyp.spring.dao.UserDao;

@Repository
public class UserDaoImpl implements UserDao {


    public void getUser() {
        System.out.println("获取user");
    }
}
