package com.yyp.spring.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yyp.spring.Entity.User;
import com.yyp.spring.dao.UserDao;
import com.yyp.spring.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    public void getUser() {
        userDao.getUser();
    }

    public User getObject() {
        System.out.println("泛型User");
        return null;
    }
}
