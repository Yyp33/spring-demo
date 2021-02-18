package com.yyp.spring.service.impl;

import com.yyp.spring.dao.UserDao;
import com.yyp.spring.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LogServiceImpl implements LogService {

    @Autowired
    UserDao userDao;

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void log(){
        System.out.println("记录日志");
        userDao.add();
    }
}
