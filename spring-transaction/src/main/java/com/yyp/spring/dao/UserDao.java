package com.yyp.spring.dao;

import com.yyp.spring.entity.User;

public interface UserDao {
    User getUser();

    void sub();

    void add();
}
