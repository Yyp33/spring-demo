package com.yyp.spring.service.impl;

import com.yyp.spring.dao.UserDao;
import com.yyp.spring.entity.User;
import com.yyp.spring.service.LogService;
import com.yyp.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private LogService logService;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public User getUser(){
        int i=0/0;//测试父方法含有事务是否融合进去
        return  userDao.getUser();
    }

    /**
     * 转账功能
     * 隔离级别
     *  使用数据库的隔离级别
     *  @Transactional(isolation = Isolation.DEFAULT)
     *  读已提交
     *  @Transactional(isolation = Isolation.READ_COMMITTED)
     *  可重复读
     *  @Transactional(isolation = Isolation.REPEATABLE_READ)
     *  串读
     *  @Transactional(isolation = Isolation.SERIALIZABLE)
     */
    @Override
    @Transactional(timeout = 2)
    public void trans(){
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        logService.log();//事务传播行为required_new会开启新的事务，不受现在事务的影响
        sub();
        add();
        getUser();

    }

    /**
     * 扣钱
     */
    @Override
    @Transactional
    public void sub(){
        System.out.println("张三减去100");
        userDao.sub();
    }

    /**
     * 加钱
     */
    @Override
    @Transactional
    public void add(){
        System.out.println("李四加100");
        int i = 0/0;
        userDao.add();
    }
}
