package com.yyp.spring.service;

import com.yyp.spring.entity.User;

public interface UserService {
    User getUser();

    void trans();

    void sub();

    void add();
}
